package com.adminision;
 
import java.time.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.beneficiarios.base.*;
import com.beneficiarios.clinica.*;
import com.clientes.*;
import com.extensiones.*;

import lombok.*;

@Entity @Getter @Setter
@View(name = "Simple", // Esta vista solo se usarÃ¡ cuando se especifique âSimpleâ
		members = "id, pacienteAtender,descripcion" // Muestra Ãºnicamente numero y nombre en la misma lÃ­nea
)
@View(name = "SimpleE", // Esta vista solo se usarÃ¡ cuando se especifique âSimpleâ
	members = "id, descripcion" // Muestra Ãºnicamente numero y nombre en la misma lÃ­nea
)


@View(members= // Esta vista no tiene nombre, por tanto será la vista usada por defecto
"numero, nomenclatura, casoCerrado;" +
		
"  Inicio { " +
" Fechas [ fechaDeEntrada, fechaDeSalida ]; " +
"razonDeAsistenaciaMedica;" +
" } " +
//"  Buscar Beneficiario { buscarBeneficiariosConPolizas; beneficiarioConPoliza; buscarBeneficiariosConContrato; beneficiarioConContrato; buscarBeneficiarioHabitual; beneficiarioHabitual; buscarBeneficiarioDeLaClinica; beneficiarioDeLaClinica; " +
"  Buscar Beneficiario { consultaDeBeneficiario; " +
" } " +
" Informacion Base { Aseguradora Empresa [" +
"numeroDeAseguradora, nombreDeLaAseguradora;" +
"numeroDeEmpresa, nombreDeLaEmpresa;" +
"];" +
" Convenio [" +
"numeroDeContrato, nombreDelContrato;" +
"numeroDePoliza, nombreDeLaPoliza;" +
"];" +
" Datos del Beneficiario [" +
"numeroDelTitular, nombreDelTitular;" +
"numeroDelBeneficiario, nombreDelBeneficiario;" +
"];" +
" Porcentajes [" +
" deducibleFijoDelPaciente; deducibleVariableDelPaciente;" +
"]"
+ " } " +
" Ingreso {" +
" numeroDeDocumentoDeIngreso; " + 
" pacienteAtender;" +
" observaciones; " +
" } " +
" Condicion Especial {" +
" personalQuienAutoriza; " + 
" personalQuienAvala;" +
" } " 


)

@Tab(baseCondition = "${casoCerrado} = false")
@Tab(name = "Cerrado", baseCondition = "${casoCerrado} = true")
public class Admision extends Incrementable4 {

	@Column(length = 25)
	@DefaultValueCalculator(CalcularAdmision.class) // Año actual	//@ReadOnly // El usuario no puede modificar el valor
	@ReadOnly
	@SearchKey
	Long numero;

    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    @ReadOnly
    @Hidden
    LocalDate fechaDeCreacion;
    
    @Column(length=255) // La longitud de columna se usa a nivel UI y a nivel DB
    @ReadOnly
    @DefaultValueCalculator(CalcularNomenclaturaAdmision.class) // Fecha actual
    String nomenclatura;
    
    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
	LocalDate fechaDeEntrada;
        
    @ManyToOne(fetch=FetchType.LAZY, optional=true) // El cliente es obligatorio
    @ReferenceView("SimpleE") // La vista llamada 'Simple' se usar� para visualizar esta referencia
    BeneficiariosBase consultaDeBeneficiario;

    
  /*  
   // @OnChange(MostrarBCP.class) 
    boolean buscarBeneficiariosConPolizas;
    
   // @OnChange(MostrarBCP.class)
    boolean buscarBeneficiariosConContrato;
    
   // @OnChange(MostrarBCP.class)
    boolean buscarBeneficiarioHabitual;
    
   // @OnChange(MostrarBCP.class)
    boolean buscarBeneficiarioDeLaClinica;

   // @OnChange(MostrarBCP.class)
    @ManyToOne(fetch=FetchType.LAZY, optional=true) // El cliente es obligatorio
    @ReferenceView("SimpleE") // La vista llamada 'Simple' se usar� para visualizar esta referencia
    BeneficiariosConPolizas beneficiarioConPoliza;

    
  //  @OnChange(MostrarBCP.class)
    @ManyToOne(fetch=FetchType.LAZY, optional=true) // El cliente es obligatorio
    @ReferenceView("SimpleE") // La vista llamada 'Simple' se usar� para visualizar esta referencia
    BeneficiariosConContratos beneficiarioConContrato;
    
    
   // @OnChange(MostrarBCP.class)
    @ManyToOne(fetch=FetchType.LAZY, optional=true) // El cliente es obligatorio
    @ReferenceView("SimpleE") // La vista llamada 'Simple' se usar� para visualizar esta referencia
    BeneficiariosHabituales beneficiarioHabitual;

    
   // @OnChange(MostrarBCP.class)
    @ManyToOne(fetch=FetchType.LAZY, optional=true) // El cliente es obligatorio
    @ReferenceView("SimpleE") // La vista llamada 'Simple' se usar� para visualizar esta referencia
    BeneficiariosDeLaClinica beneficiarioDeLaClinica;
*/    
    
    @ReadOnly
	Double numeroDeAseguradora;

    @Column(length=255) // La longitud de columna se usa a nivel UI y a nivel DB
    @ReadOnly
    String nombreDeLaAseguradora;
    
    @ReadOnly
	Double numeroDeEmpresa;
    
    @Column(length=255) // La longitud de columna se usa a nivel UI y a nivel DB
    @ReadOnly
    String nombreDeLaEmpresa;
    
    @ReadOnly
    Double numeroDeContrato;
    
    @Column(length=255) // La longitud de columna se usa a nivel UI y a nivel DB
    @ReadOnly
    String nombreDelContrato;
    
    @ReadOnly
    Double numeroDePoliza;
    
    @Column(length=255) // La longitud de columna se usa a nivel UI y a nivel DB
    @ReadOnly
    String nombreDeLaPoliza;

    @ReadOnly
	@Column(length = 20)
    String numeroDelTitular;
    
    @Column(length=255) // La longitud de columna se usa a nivel UI y a nivel DB
    @ReadOnly
    String nombreDelTitular;
    
    @ReadOnly
	@Column(length = 20)
    String numeroDelBeneficiario;
    
    @Column(length=255) // La longitud de columna se usa a nivel UI y a nivel DB
    @ReadOnly
    String nombreDelBeneficiario;
    
	@ManyToOne( // La referencia se almacena como una relaciÃ³n en la base de datos
			fetch = FetchType.LAZY, // La referencia se carga bajo demanda
			optional = true) // La referencia puede estar sin valor
	@ReferenceView("SimpleE")
	Paciente pacienteAtender; // Una referencia Java convencional

	@ManyToOne( // La referencia se almacena como una relaciÃ³n en la base de datos
			fetch = FetchType.LAZY, // La referencia se carga bajo demanda
			optional = true) // La referencia puede estar sin valor
	@DescriptionsList // AsÃ­ la referencia se visualiza usando un combo
	RazonDeAsistenciaMedica razonDeAsistenaciaMedica; // Una referencia Java convencional

	@Column(length = 30)
    String numeroDeDocumentoDeIngreso;
	
    @ReadOnly
	@Column(length = 7)
    Double deducibleFijoDelPaciente;

	@Column(length = 7)
    Double deducibleVariableDelPaciente;

	@ManyToOne( // La referencia se almacena como una relaciÃ³n en la base de datos
			fetch = FetchType.LAZY, // La referencia se carga bajo demanda
			optional = true) // La referencia puede estar sin valor
	@DescriptionsList // AsÃ­ la referencia se visualiza usando un combo
	@ReferenceView("SimpleEmp")
	BeneficiariosDeLaClinica personalQuienAutoriza; // Una referencia Java convencional
	
	@ManyToOne( // La referencia se almacena como una relaciÃ³n en la base de datos
			fetch = FetchType.LAZY, // La referencia se carga bajo demanda
			optional = true) // La referencia puede estar sin valor
	@DescriptionsList // AsÃ­ la referencia se visualiza usando un combo
	@ReferenceView("SimpleEmp")
	BeneficiariosDeLaClinica personalQuienAvala; // Una referencia Java convencional
	
	boolean casoCerrado;
	
	LocalDate fechaDeSalida;
    
    @TextArea
    String observaciones;	
    
}






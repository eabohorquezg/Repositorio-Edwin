//Autor: Edwin Alexander
//Descripcion: Este es un ejemplo sencillo de herencia en Groovy

class Persona{
	String nombre
	int edad

	//constructor
	Persona(){}
}

class Empleado extends Persona{
	String tipo
	double salario
	
	//constructor
	Empleado(){}
}

static main(args) {
	def person = new Persona(nombre:"Pepito",edad:32)
	def trabajador = new Empleado()

	trabajador.with{
	nombre = "Edwin"
	edad = 22
	tipo = "ejecutivo"
	salario = 5000000
	}

	println "Persona:"
	println "nombre : ${person.nombre}, edad : ${person.edad}"

	println "Trabajador:"
	println "nombre : ${trabajador.nombre}, edad : ${trabajador.edad}, tipo : ${trabajador.tipo}, salario : ${trabajador.salario}"
}

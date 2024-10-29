package com.example.calculadoracientifica

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var pantallaPrimaria: TextView
    lateinit var pantallaSecundaria: TextView
    lateinit var botonBorraTodo: Button
    lateinit var botonBorraUno: Button
    lateinit var botonAbreParentesis: Button
    lateinit var botonCierraParentesis: Button
    lateinit var botonSeno: Button
    lateinit var botonCoseno: Button
    lateinit var botonTangente: Button
    lateinit var botonLogaritmo: Button
    lateinit var botonNeperiano: Button
    lateinit var botonFactorial: Button
    lateinit var botonExponencial: Button
    lateinit var botonRaizCuadrada: Button
    lateinit var botonPorcentaje: Button
    lateinit var botonDivision: Button
    lateinit var botonNum1: Button
    lateinit var botonNum2: Button
    lateinit var botonNum3: Button
    lateinit var botonNum4: Button
    lateinit var botonNum5: Button
    lateinit var botonNum6: Button
    lateinit var botonNum7: Button
    lateinit var botonNum8: Button
    lateinit var botonNum9: Button
    lateinit var botonNum0: Button
    lateinit var botonHistorial: Button
    lateinit var botonPunto: Button
    lateinit var botonSuma: Button
    lateinit var botonResta: Button
    lateinit var botonMultiplicacion: Button
    lateinit var botonIgual: Button
    lateinit var botonNumPi: Button

    var suma: Boolean = false
    var resta: Boolean = false
    var multi: Boolean = false
    var divide: Boolean = false
    var tan: Boolean = false
    var cos: Boolean = false
    var se: Boolean = false
    var log: Boolean = false
    var porc: Boolean = false
    var raiz: Boolean = false
    var ln: Boolean = false
    var decimal: Boolean = false
    var exp: Boolean = false
    var fact: Boolean = false
    var numero: Array<Double?> = arrayOfNulls(20)
    var resultado: Double? = null
    var historial: MutableList<String> = mutableListOf()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        pantallaPrimaria = findViewById(R.id.PantallaPrimaria)
        pantallaSecundaria = findViewById(R.id.PantallaSecundaria)
        botonBorraTodo = findViewById(R.id.BotonBorraTodo)
        botonBorraUno = findViewById(R.id.BotonBorraUno)
        botonSeno = findViewById(R.id.BotonSeno)
        botonCoseno = findViewById(R.id.BotonCoseno)
        botonTangente = findViewById(R.id.BotonTangente)
        botonLogaritmo = findViewById(R.id.BotonLogaritmo)
        botonNeperiano = findViewById(R.id.BotonNeperiano)
        botonFactorial = findViewById(R.id.BotonFactorial)
        botonExponencial = findViewById(R.id.BotonExponencial)
        botonRaizCuadrada = findViewById(R.id.BotonRaizCuadrada)
        botonPorcentaje = findViewById(R.id.botonPorcentaje)
        botonDivision = findViewById(R.id.BotonDivision)
        botonNum1 = findViewById(R.id.BotonNum1)
        botonNum2 = findViewById(R.id.BotonNum2)
        botonNum3 = findViewById(R.id.BotonNum3)
        botonNum4 = findViewById(R.id.BotonNum4)
        botonNum5 = findViewById(R.id.BotonNum5)
        botonNum6 = findViewById(R.id.BotonNum6)
        botonNum7 = findViewById(R.id.BotonNum7)
        botonNum8 = findViewById(R.id.BotonNum8)
        botonNum9 = findViewById(R.id.BotonNum9)
        botonNum0 = findViewById(R.id.BotonNum0)
        botonHistorial = findViewById(R.id.BotonHistorial)
        botonPunto = findViewById(R.id.BotonPunto)
        botonSuma = findViewById(R.id.BotonSuma)
        botonResta = findViewById(R.id.BotonResta)
        botonMultiplicacion = findViewById(R.id.BotonMultiplicacion)
        botonIgual = findViewById(R.id.BotonIgual)
        botonNumPi = findViewById(R.id.BotonNumPi)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        botonNum0.setOnClickListener {
            pantallaPrimaria.text = (pantallaPrimaria.text.toString() + "0")
        }
        botonNum1.setOnClickListener {
            pantallaPrimaria.text = (pantallaPrimaria.text.toString() + "1")
        }
        botonNum2.setOnClickListener {
            pantallaPrimaria.text = (pantallaPrimaria.text.toString() + "2")
        }
        botonNum3.setOnClickListener {
            pantallaPrimaria.text = (pantallaPrimaria.text.toString() + "3")
        }
        botonNum4.setOnClickListener {
            pantallaPrimaria.text = (pantallaPrimaria.text.toString() + "4")
        }
        botonNum5.setOnClickListener {
            pantallaPrimaria.text = (pantallaPrimaria.text.toString() + "5")
        }
        botonNum6.setOnClickListener {
            pantallaPrimaria.text = (pantallaPrimaria.text.toString() + "6")
        }
        botonNum7.setOnClickListener {
            pantallaPrimaria.text = (pantallaPrimaria.text.toString() + "7")
        }
        botonNum8.setOnClickListener {
            pantallaPrimaria.text = (pantallaPrimaria.text.toString() + "8")
        }
        botonNum9.setOnClickListener {
            pantallaPrimaria.text = (pantallaPrimaria.text.toString() + "9")
        }
        botonNumPi.setOnClickListener {
            pantallaPrimaria.text = (pantallaPrimaria.text.toString() + "3.1415")
            pantallaSecundaria.text = "π"
        }
        botonPunto.setOnClickListener {
            var a: String = pantallaPrimaria.text.toString()
            if (!decimal) {
                a = pantallaPrimaria.text.toString()
                pantallaPrimaria.text = "$a."
                decimal = true
            }
        }
        botonSuma.setOnClickListener {
            var a: String = pantallaPrimaria.text.toString()
            if (a.isEmpty()) {
                Toast.makeText(this, "El campo no puede estar vacío.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try {
                suma = true
                numero[0] = a.toDouble()
                pantallaPrimaria.text = ""
                decimal = false
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        botonResta.setOnClickListener {
            var a: String = pantallaPrimaria.text.toString()
            if (a.isEmpty()) {
                pantallaPrimaria.text = "-"
                // Asumimos que el próximo número ingresado será negativo
                numero[0] =
                    0.0 // Inicializamos numero[0] a 0.0 para que el próximo número sea tratado como negativo
            } else {
                try {
                    numero[0] = a.toDouble()
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT)
                        .show()
                }
                resta = true
                pantallaPrimaria.text=""
                decimal = false
            }
        }

        botonMultiplicacion.setOnClickListener {
            var a: String = pantallaPrimaria.text.toString()
            if (a.isEmpty()) {
                Toast.makeText(this, "El campo no puede estar vacío.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try {
                multi = true
                numero[0] = a.toDouble()
                pantallaPrimaria.text = ""
                decimal = false
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT)
                    .show()
            }

        }
        botonDivision.setOnClickListener {
            var a: String = pantallaPrimaria.text.toString()
            if (a.isEmpty()) {
                Toast.makeText(this, "El campo no puede estar vacío.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try {
                divide = true
                numero[0] = a.toDouble()
                pantallaPrimaria.text = ""
                decimal = false
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        botonHistorial.setOnClickListener {
            mostrarHistorial()
        }
        botonSeno.setOnClickListener {
            var a: String = pantallaPrimaria.text.toString()
            if (a.isEmpty()) {
                Toast.makeText(this, "El campo no puede estar vacío.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try {
                numero[0] = a.toDouble()
                val numero1 = numero[0] ?: 0.0
                se = true
                val valorEnRadianes = convertirGradosARadianes(numero[0]!!)
                resultado = Math.sin(valorEnRadianes)
                pantallaPrimaria.text = resultado.toString()
                decimal = false
                guardarEnHistorial("El seno de $numero1 es $resultado")
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        botonCoseno.setOnClickListener {
            var a: String = pantallaPrimaria.text.toString()
            if (a.isEmpty()) {
                Toast.makeText(this, "El campo no puede estar vacío.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try {
                numero[0] = a.toDouble()
                val numero1 = numero[0] ?: 0.0
                cos = true
                val valorEnRadianes = convertirGradosARadianes(numero[0]!!)
                resultado = Math.cos(valorEnRadianes)
                pantallaPrimaria.text = resultado.toString()
                decimal = false
                guardarEnHistorial("El coseno de $numero1  es $resultado")
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        botonTangente.setOnClickListener {
            var a: String = pantallaPrimaria.text.toString()
            if (a.isEmpty()) {
                Toast.makeText(this, "El campo no puede estar vacío.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try {
                numero[0] = a.toDouble()
                val numero1 = numero[0] ?: 0.0
                tan = true
                val valorEnRadianes = convertirGradosARadianes(numero[0]!!)
                resultado = Math.tan(valorEnRadianes)
                pantallaPrimaria.text = resultado.toString()
                guardarEnHistorial("La tangente de $numero1  es $resultado")

                decimal = false
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        botonPorcentaje.setOnClickListener {
            var a: String = pantallaPrimaria.text.toString()
            if (a.isEmpty()) {
                Toast.makeText(this, "El campo no puede estar vacío.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try {
                porc = true
                numero[0] = a.toDouble()
                pantallaPrimaria.text = ""
                decimal = false
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        botonLogaritmo.setOnClickListener {
            var a: String = pantallaPrimaria.text.toString()
            if (a.isEmpty()) {
                Toast.makeText(this, "El campo no puede estar vacío.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try {
                numero[0] = a.toDouble()
                log = true
                if (numero[0]!! <= 0) {
                    Toast.makeText(
                        this,
                        "El logaritmo solo está definido para números positivos.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    resultado = Math.log10(numero[0]!!)
                    val numero1 = numero[0] ?: 0.0
                    pantallaPrimaria.text = resultado.toString()
                    guardarEnHistorial("El logaritmo de $numero1  es $resultado")
                }
                decimal = false
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        botonNeperiano.setOnClickListener {
            var a: String = pantallaPrimaria.text.toString()
            if (a.isEmpty()) {
                Toast.makeText(this, "El campo no puede estar vacío.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try {
                numero[0] = a.toDouble()
                ln = true
                if (numero[0]!! <= 0) {
                    Toast.makeText(
                        this,
                        "El logaritmo solo está definido para números positivos.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    resultado = Math.log(numero[0]!!)
                    val numero1 = numero[0] ?: 0.0
                    pantallaPrimaria.text = resultado.toString()
                    guardarEnHistorial("El neperiano de $numero1  es $resultado")
                }
                decimal = false
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        botonRaizCuadrada.setOnClickListener {
            var a: String = pantallaPrimaria.text.toString()
            if (a.isEmpty()) {
                Toast.makeText(this, "El campo no puede estar vacío.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try {
                numero[0] = a.toDouble()
                raiz = true
                if (numero[0]!! < 0) {
                    Toast.makeText(
                        this,
                        "No se pueden hacer raíces de numeros negativos",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    resultado = Math.sqrt(numero[0]!!)
                    val numero1 = numero[0] ?: 0.0
                    pantallaPrimaria.text = resultado.toString()
                    guardarEnHistorial("La raiz cuadrada de $numero1  es $resultado")
                }
                decimal = false
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        botonBorraTodo.setOnClickListener {
            pantallaPrimaria.text = ""
            pantallaSecundaria.text = ""
        }

        botonBorraUno.setOnClickListener {
            var a: String = pantallaPrimaria.text.toString()
            if (a.isNotEmpty()) {
                val cadena = a.substring(0, a.length - 1)
                pantallaPrimaria.text = cadena
            }
        }

        botonExponencial.setOnClickListener {
            var a: String = pantallaPrimaria.text.toString()
            if (a.isEmpty()) {
                Toast.makeText(this, "El campo no puede estar vacío.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try {
                numero[0] = a.toDouble()
                exp = true
                pantallaPrimaria.text = ""
                decimal = false
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        botonFactorial.setOnClickListener {
            var a: String = pantallaPrimaria.text.toString()
            if (a.isEmpty()) {
                Toast.makeText(this, "Por favor, introduzca un valor válido", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            try {
                numero[0]=a.toDouble()
                if (numero[0] != null) {
                    val entero = numero[0]!!.toInt()
                    if (entero >= 0) {
                        val fact = factorial (entero)
                        pantallaPrimaria.text = fact.toString()
                        guardarEnHistorial("El factorial de $entero es $fact")
                    } else {
                        Toast.makeText(
                            this,
                            "El factorial no está definido para números negativos",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(this, "El valor ingresado es nulo", Toast.LENGTH_SHORT).show()
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT)
                    .show()
            }
        }


            botonIgual.setOnClickListener {
                var a: String = pantallaPrimaria.text.toString()
                if (a.isEmpty()) {
                    Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                try{
                    numero[1] = a.toDoubleOrNull() ?: 0.0

                    if (numero[1] == null) {
                        Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                    if (suma == true) {
                        resultado = numero[0]?.plus(numero[1] ?: 0.0) // Asegurarse de que ambos valores no sean nulos
                        val numero1 = numero[0] ?: 0.0
                        val numero2 = numero[1] ?: 0.0
                        pantallaPrimaria.text = resultado.toString()
                        suma = false
                        guardarEnHistorial("Resultado de la suma entre $numero1  y $numero2  es $resultado")
                        numero[0] = null
                        numero[1] = null

                    } else if (resta==true){
                        resultado=numero[0]?.minus(numero[1]?:0.0)
                        val numero1 = numero[0] ?: 0.0
                        val numero2 = numero[1] ?: 0.0
                        pantallaPrimaria.text = resultado.toString()
                        resta=false
                        guardarEnHistorial("Resultado de la resta entre $numero1  y $numero2 es $resultado")
                        numero[0] = null
                        numero[1] = null

                    } else if (multi==true){
                        resultado=numero[0]?.times((numero[1]?:0.0))
                        val numero1 = numero[0] ?: 0.0
                        val numero2 = numero[1] ?: 0.0
                        pantallaPrimaria.text = resultado.toString()
                        multi=false
                        guardarEnHistorial("Resultado de la multiplicacion entre $numero1  y $numero2 es $resultado")
                        numero[0] = null
                        numero[1] = null

                    } else if(divide==true){
                        if (numero[1] == 0.0) {
                            Toast.makeText(this, "No se puede dividir entre cero.", Toast.LENGTH_SHORT).show()
                            return@setOnClickListener
                        } else {
                            resultado=numero[0]!! / numero[1]!!
                            val numero1 = numero[0] ?: 0.0
                            val numero2 = numero[1] ?: 0.0
                            guardarEnHistorial("Resultado de la division entre $numero1  y $numero2 es $resultado")
                        }
                        pantallaPrimaria.text = resultado.toString()
                        divide=false
                        numero[0] = null
                        numero[1] = null
                    } else if (porc==true){
                        resultado=(numero[0]!! * (numero[1] ?: 0.0)) / 100
                        val numero1 = numero[0] ?: 0.0
                        val numero2 = numero[1] ?: 0.0
                        pantallaPrimaria.text = resultado.toString()
                        porc=false
                        guardarEnHistorial("El $numero1 por ciento de $numero2 es $resultado")
                        numero[0] = null
                        numero[1] = null

                    } else if(exp==true){
                        resultado=Math.pow(numero[0]!!, numero[1] ?: 0.0)
                        val numero1 = numero[0] ?: 0.0
                        val numero2 = numero[1] ?: 0.0
                        pantallaPrimaria.text = resultado.toString()
                        exp=false
                        guardarEnHistorial("$numero1 elevado a  $numero2 es $resultado")
                        numero[0] = null
                        numero[1] = null

                    }

            }  catch (e: NumberFormatException) {
                    Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT).show()
        }

    }
}
    fun factorial(n: Int): Int {
        return if (n == 0 || n == 1) {
            1
        } else {
            n * factorial(n - 1)
        }
    }
    fun convertirGradosARadianes(grados: Double): Double {
        return Math.toRadians(grados)
    }

    fun guardarEnHistorial(entrada:String){
        historial.add(entrada)
    }

    fun mostrarHistorial(){
        val intent = Intent(this, HistorialActivity::class.java)
        intent.putStringArrayListExtra("HISTORIAL", ArrayList(historial))
        startActivity(intent)
    }

}
package com.example.calculadoracientifica

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var pantallaPrimaria : TextView
    lateinit var pantallaSecundaria : TextView
    lateinit var botonBorraTodo : Button
    lateinit var botonBorraUno : Button
    lateinit var botonAbreParentesis : Button
    lateinit var botonCierraParentesis : Button
    lateinit var botonSeno : Button
    lateinit var botonCoseno : Button
    lateinit var botonTangente : Button
    lateinit var botonLogaritmo : Button
    lateinit var botonNeperiano : Button
    lateinit var botonFactorial : Button
    lateinit var botonCuadrado : Button
    lateinit var botonRaizCuadrada : Button
    lateinit var botonInversa : Button
    lateinit var botonDivision : Button
    lateinit var botonNum1 : Button
    lateinit var botonNum2 : Button
    lateinit var botonNum3 : Button
    lateinit var botonNum4 : Button
    lateinit var botonNum5 : Button
    lateinit var botonNum6 : Button
    lateinit var botonNum7 : Button
    lateinit var botonNum8 : Button
    lateinit var botonNum9 : Button
    lateinit var botonNum0 : Button
    lateinit var botonNumPi : Button
    lateinit var botonPunto : Button
    lateinit var botonSuma : Button
    lateinit var botonResta : Button
    lateinit var botonMultiplicacion : Button
    lateinit var botonIgual : Button

    var suma: Boolean = false
    var resta: Boolean = false
    var multi: Boolean = false
    var divide: Boolean = false
    var targ: Boolean = false
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
    val a: String = pantallaPrimaria.getText().toString()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        pantallaPrimaria = findViewById(R.id.PantallaPrimaria)
        pantallaSecundaria = findViewById(R.id.PantallaSecundaria)
        botonBorraTodo = findViewById(R.id.BotonBorraTodo)
        botonBorraUno = findViewById(R.id.BotonBorraUno)
        botonAbreParentesis = findViewById(R.id.BotonAbreParentesis)
        botonCierraParentesis = findViewById(R.id.BotonCierraParentesis)
        botonSeno = findViewById(R.id.BotonSeno)
        botonCoseno = findViewById(R.id.BotonCoseno)
        botonTangente = findViewById(R.id.BotonTangente)
        botonLogaritmo = findViewById(R.id.BotonLogaritmo)
        botonNeperiano = findViewById(R.id.BotonNeperiano)
        botonFactorial = findViewById(R.id.BotonFactorial)
        botonCuadrado = findViewById(R.id.BotonCuadrado)
        botonRaizCuadrada = findViewById(R.id.BotonRaizCuadrada)
        botonInversa = findViewById(R.id.BotonInversa)
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
        botonNumPi = findViewById(R.id.BotonNumPi)
        botonPunto = findViewById(R.id.BotonPunto)
        botonSuma = findViewById(R.id.BotonSuma)
        botonResta = findViewById(R.id.BotonResta)
        botonMultiplicacion = findViewById(R.id.BotonMultiplicacion)
        botonIgual = findViewById(R.id.BotonIgual)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        botonNum0.setOnClickListener{
            pantallaPrimaria.text=(pantallaPrimaria.text.toString()+"0")
        }
        botonNum1.setOnClickListener{
            pantallaPrimaria.text=(pantallaPrimaria.text.toString()+"1")
        }
        botonNum2.setOnClickListener{
            pantallaPrimaria.text=(pantallaPrimaria.text.toString()+"2")
        }
        botonNum3.setOnClickListener{
            pantallaPrimaria.text=(pantallaPrimaria.text.toString()+"3")
        }
        botonNum4.setOnClickListener{
            pantallaPrimaria.text=(pantallaPrimaria.text.toString()+"4")
        }
        botonNum5.setOnClickListener{
            pantallaPrimaria.text=(pantallaPrimaria.text.toString()+"5")
        }
        botonNum6.setOnClickListener{
            pantallaPrimaria.text=(pantallaPrimaria.text.toString()+"6")
        }
        botonNum7.setOnClickListener{
            pantallaPrimaria.text=(pantallaPrimaria.text.toString()+"7")
        }
        botonNum8.setOnClickListener{
            pantallaPrimaria.text=(pantallaPrimaria.text.toString()+"8")
        }
        botonNum9.setOnClickListener{
            pantallaPrimaria.text=(pantallaPrimaria.text.toString()+"9")
        }
        botonPunto.setOnClickListener{
            pantallaPrimaria.text=(pantallaPrimaria.text.toString()+".")
        }
        botonSuma.setOnClickListener{
            pantallaPrimaria.text=(pantallaPrimaria.text.toString()+"+")
        }

        botonResta.setOnClickListener{
            if (a.isEmpty()) {
                Toast.makeText(this, "El campo no puede estar vacío.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try {
                resta = true
                numero[0]=a.toDouble()
                pantallaPrimaria.text=""
                decimal=false
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        botonMultiplicacion.setOnClickListener{
            if (a.isEmpty()) {
                Toast.makeText(this, "El campo no puede estar vacío.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try {
                multi = true
                numero[0]=a.toDouble()
                pantallaPrimaria.text=""
                decimal=false
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT)
                    .show()
            }

        }
        botonDivision.setOnClickListener{
            if (a.isEmpty()) {
                Toast.makeText(this, "El campo no puede estar vacío.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try {
                multi = true
                numero[0]=a.toDouble()
                pantallaPrimaria.text=""
                decimal=false
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        botonAbreParentesis.setOnClickListener{
            pantallaPrimaria.text=(pantallaPrimaria.text.toString()+"(")
        }
        botonCierraParentesis.setOnClickListener{
            pantallaPrimaria.text=(pantallaPrimaria.text.toString()+")")
        }
        botonNumPi.setOnClickListener{
            pantallaPrimaria.text=(pantallaPrimaria.text.toString()+"3.1415")
            pantallaSecundaria.text="π"
        }
        botonSeno.setOnClickListener{
            val valorTexto = pantallaPrimaria.text.toString()
            if (valorTexto.isNotEmpty()) {
                try {
                    val valorEnGrados = valorTexto.toDouble()
                    val valorEnRadianes = convertirGradosARadianes(valorEnGrados)
                    val resultadoSeno = Math.sin(valorEnRadianes)
                    pantallaPrimaria.text = resultadoSeno.toString()
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT).show()
                }
            } else {
                pantallaPrimaria.text = "0"
            }
        }
        botonCoseno.setOnClickListener{
            if (a.isEmpty()) {
                Toast.makeText(this, "El campo no puede estar vacío.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try {
                cos = true
                numero[0] = a.toDouble()
                if (numero[0] != null) {
                    resultado = Math.cos(numero[0]!!)
                    // Mostrar el resultado en la pantalla
                    pantallaPrimaria.text = resultado.toString()
                } else {
                    Toast.makeText(this, "Por favor ingresa un número válido antes de calcular el coseno.", Toast.LENGTH_SHORT).show()
                }
                decimal=false
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        botonTangente.setOnClickListener{
            val valorTexto = pantallaPrimaria.text.toString()
            if (valorTexto.isNotEmpty()) {
                try {
                    val valorEnGrados = valorTexto.toDouble()
                    val valorEnRadianes = convertirGradosARadianes(valorEnGrados)
                    val resultadoTangente = Math.tan(valorEnRadianes)
                    pantallaPrimaria.text = resultadoTangente.toString()
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT).show()
                }
            } else {
                pantallaPrimaria.text = "0"
            }
        }
        botonInversa.setOnClickListener{
            pantallaPrimaria.text=(pantallaPrimaria.text.toString()+"^"+"-1")
        }
        botonLogaritmo.setOnClickListener{
            val valorTexto = pantallaPrimaria.text.toString()
            if (valorTexto.isNotEmpty()) {
                try {
                    val valor = valorTexto.toDouble()
                    // Comprobar que el valor sea positivo, ya que el logaritmo de números negativos no está definido
                    if (valor <= 0) {
                        Toast.makeText(this, "El logaritmo solo está definido para números positivos.", Toast.LENGTH_SHORT).show()
                    } else {
                        val resultadoLogaritmo = Math.log10(valor)
                        pantallaPrimaria.text = resultadoLogaritmo.toString()
                    }
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT).show()
                }
            } else {
                pantallaPrimaria.text = "0"
            }
        }
        botonNeperiano.setOnClickListener{
            val valorTexto = pantallaPrimaria.text.toString()
            if (valorTexto.isNotEmpty()) {
                try {
                    val valor = valorTexto.toDouble()
                    // Comprobar que el valor sea positivo, ya que el logaritmo neperiano de números negativos no está definido
                    if (valor <= 0) {
                        Toast.makeText(this, "El logaritmo neperiano solo está definido para números positivos.", Toast.LENGTH_SHORT).show()
                    } else {
                        val resultadoLogaritmo = Math.log(valor) // Logaritmo neperiano
                        pantallaPrimaria.text = resultadoLogaritmo.toString()
                    }
                } catch (e: NumberFormatException) {
                    Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT).show()
                }
            } else {
                pantallaPrimaria.text = "0"
            }
        }

        botonRaizCuadrada.setOnClickListener {
            if (pantallaPrimaria.text.toString().isEmpty()) {
                Toast.makeText(this, "Por favor, introduzca un número válido", Toast.LENGTH_SHORT).show()
            } else {
                val valor: String = pantallaPrimaria.text.toString()
                val raiz = valor.toDouble()
                if (raiz < 0) {
                    Toast.makeText(
                        this,
                        "No se puede calcular la raíz cuadrada de un número negativo",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val resultado = Math.sqrt(raiz)
                    pantallaPrimaria.text = raiz.toString()
                }
            }
        }

        botonBorraTodo.setOnClickListener{
            pantallaPrimaria.text=""
            pantallaSecundaria.text=""
        }

        botonBorraUno.setOnClickListener{
            var texto: String = pantallaPrimaria.text.toString()
            if (texto.isNotEmpty()){
                texto = texto.substring(0,texto.length-1)
                pantallaPrimaria.text=texto
            }
        }

        botonCuadrado.setOnClickListener{
            if (pantallaPrimaria.text.toString().isEmpty()){
                Toast.makeText(this, "Por favor, introduzca un valor válido", Toast.LENGTH_SHORT).show()
            } else{
                val valor: Double = pantallaPrimaria.text.toString().toDouble()
                val cuadrado= valor*valor
                pantallaPrimaria.text=cuadrado.toString()
                pantallaSecundaria.text=cuadrado.toString()
            }
        }

        botonFactorial.setOnClickListener{
            if (pantallaPrimaria.text.toString().isEmpty()){
                Toast.makeText(this, "Por favor, introduzca un valor válido", Toast.LENGTH_SHORT).show()
            } else{
                val valor: Int = pantallaPrimaria.text.toString().toInt()
                val fact : Int = factorial(valor)
                pantallaPrimaria.text=fact.toString()
                pantallaSecundaria.text=fact.toString()
            }
        }
        botonIgual.setOnClickListener{
            val expresion = pantallaPrimaria.text.toString()
            try {
                val resultado = evaluarExpresion(expresion)
                pantallaPrimaria.text = resultado.toString()
                pantallaSecundaria.text = expresion
            } catch (e: Exception) {
                Toast.makeText(this, "Por favor ingresa un número válido.", Toast.LENGTH_SHORT).show()
            }
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

    fun formatearResultado(resultado: Double): String {
        return if (resultado % 1.0 == 0.0) { // Comprobar si es un número entero
            resultado.toInt().toString() // Convertir a entero y devolver como cadena
        } else {
            resultado.toString() // Devolver como cadena con decimales
        }
    }

    fun evaluarExpresion(expresion: String): Double {
        val tokens = mutableListOf<String>()
        val numberBuffer = StringBuilder()

        for (char in expresion) {
            if (char.isDigit() || char == '.') {
                numberBuffer.append(char)  // Acumula los dígitos y el punto decimal
            } else {
                if (numberBuffer.isNotEmpty()) {
                    tokens.add(numberBuffer.toString())  // Agrega el número acumulado a los tokens
                    numberBuffer.clear()  // Limpia el buffer para el siguiente número
                }
                if (!char.isWhitespace()) {
                    tokens.add(char.toString())  // Agrega el operador a los tokens
                }
            }
        }
        // Agregar el último número acumulado al final de la cadena
        if (numberBuffer.isNotEmpty()) {
            tokens.add(numberBuffer.toString())
        }

        return evaluarTokens(tokens)  // Llama a la función para evaluar los tokens
    }

    fun evaluarTokens(tokens: List<String>): Double {
        val values = mutableListOf<Double>()   // Almacena los números a medida que se evalúan
        val operators = mutableListOf<Char>()  // Almacena los operadores

        // Definimos la precedencia de los operadores
        val precedence = mapOf(
            '+' to 1,
            '-' to 1,
            'x' to 2,
            '/' to 2,
            '^' to 3
        )

        // Función interna para aplicar la última operación
        fun aplicarOperacion() {
            val b = values.removeAt(values.size - 1)  // Obtiene el último valor
            val a = values.removeAt(values.size - 1)  // Obtiene el penúltimo valor
            val operator = operators.removeAt(operators.size - 1)  // Obtiene el último operador

            val resultado = when (operator) {
                '+' -> a + b
                '-' -> a - b
                'x' -> a * b
                '/' -> a / b
                '^' -> Math.pow(a, b)  // Potencia usando Math.pow
                else -> throw IllegalArgumentException("Operador desconocido: $operator")
            }
            values.add(resultado)  // Agrega el resultado a la lista de valores
        }

        // Evaluamos los tokens
        for (token in tokens) {
            when {
                token.toDoubleOrNull() != null -> values.add(token.toDouble())  // Si el token es un número, lo agregamos a values
                token.length == 1 && token[0] in precedence.keys -> {  // Si el token es un operador
                    while (operators.isNotEmpty() &&
                        precedence[operators.last()]!! >= precedence[token[0]]!!) {
                        aplicarOperacion()  // Aplicamos la última operación si hay precedencia
                    }
                    operators.add(token[0])  // Agregamos el operador actual a la lista
                }
                else -> throw IllegalArgumentException("Token inválido: $token")  // Si el token no es válido
            }
        }

        // Aplicar cualquier operación restante
        while (operators.isNotEmpty()) {
            aplicarOperacion()
        }

        return values.first() // Retorna el resultado final
    }



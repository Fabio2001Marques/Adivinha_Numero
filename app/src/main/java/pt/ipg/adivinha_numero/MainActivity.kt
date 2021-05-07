package pt.ipg.adivinha_numero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    private val random = Random()
    private var numeroAdivinhar : Int = 0
    private var jogo : Int = 0
    private var tentativas : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        novoJogo()
    }

    private fun novoJogo() {
         numeroAdivinhar = random.nextInt(10) +1
        tentativas = 0
        jogo++

        atualizaJogo()
        atualizaTentativas()
    }

    private fun atualizaJogo() {
        findViewById<TextView>(R.id.textViewJogos).text = getString(R.string.jogo)+ jogo
    }

    private fun atualizaTentativas() {
        findViewById<TextView>(R.id.textViewTentativas).text = getString(R.string.tentativa)+ tentativas
    }

    fun adivinha(view: View) {

        val editTextNumero = findViewById<EditText>(R.id.EditTextNumero)

        val numero = editTextNumero.text.toString().toIntOrNull()

        when (numero){
            in 1..10 -> verificaAcertou(numero)
            null -> editTextNumero.error = getString(R.string.numero_invalido)
            else -> editTextNumero.error = getString(R.string.numero_entre_1_10)
        }

    }

    private fun verificaAcertou(numero : Int?) {
        val textViewFeedBack = findViewById<TextView>(R.id.textViewFeedBack)

        val mensagem: String

            if(numero == numeroAdivinhar){
                textViewFeedBack.text = getString(R.string.acertou)
                perguntaSeQuerJogarNovamente()
            }else if (numeroAdivinhar> numero!!){
                textViewFeedBack.text = getString(R.string.numero_maior)
            }else{
                textViewFeedBack.text = getString(R.string.numero_menor)
            }
        tentativas++
        atualizaTentativas()
    }

    private fun perguntaSeQuerJogarNovamente() {
        // todo: Colocar um alertDialog a perguntar se quer jogar novamente
    }


}
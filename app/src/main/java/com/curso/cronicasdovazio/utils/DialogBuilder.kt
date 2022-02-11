package com.curso.cronicasdovazio.utils

import android.app.Activity
import android.content.DialogInterface
import android.text.InputType
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import com.curso.cronicasdovazio.R
import com.curso.cronicasdovazio.data.FirebaseAuthRepository

class DialogBuilder {

    private val fireBaseAuthRepository = FirebaseAuthRepository()

    fun showSimpleWarningDialog(activity: Activity,title: String, warning: String) {
        createWarningDialog(activity, warning, title) {}.show()
    }

    fun createWarningDialog(activity:Activity, warning:String, title:String, function : () -> Unit): AlertDialog {
        val dialog: AlertDialog = activity.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
//              Titulo do dialog
                setTitle(title)
//              Mensagem de aviso personalizada
                setMessage(warning)
//              Botão positivo e seu click listener
                setPositiveButton(R.string.ok,
                    DialogInterface.OnClickListener { dialog, id ->
                        //Caso precise usar programação funcional para executar um método diferente nesse botão de aviso
                        function()
                        dialog.dismiss()
                    })
//                Botão negativo e seu click listener
//                setNegativeButton(
//                    R.string.cancel,
//                    DialogInterface.OnClickListener { dialog, id ->
//                        // User cancelled the dialog
//                    })
            }
            builder.create()
        }
        return dialog
    }

    fun createListDialog(activity:Activity, list:Array<String>, title:String, function: () -> Unit): AlertDialog {
        val dialog: AlertDialog = activity.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
//              Titulo do dialog
                setTitle(title)
//              Os itens trazidos e o uso
                setItems(list,
                    DialogInterface.OnClickListener { dialog, which ->
                        function()
                    })
//              Botão positivo e seu click listener
                setPositiveButton(R.string.ok,
                    DialogInterface.OnClickListener { dialog, id ->
                        dialog.dismiss()
                    })
//                Botão negativo e seu click listener
//                setNegativeButton(
//                    R.string.cancel,
//                    DialogInterface.OnClickListener { dialog, id ->
//
//                    })
            }
            builder.create()
        }
        return dialog
    }

    fun registerDialog(activity:Activity, function: () -> Unit): AlertDialog {
        val dialog: AlertDialog = activity.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setTitle("Crie sua conta")

                // Email input
                val emailInput = EditText(activity)
                emailInput.setHint("Enter Email")
                emailInput.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS

                // Password input
                val passwordInput = EditText(activity)
                passwordInput.setHint("Enter password")
                passwordInput.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD

                // Password input2
                val passwordInput2 = EditText(activity)
                passwordInput2.setHint("Confirm password")
                passwordInput2.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD

                var layout = LinearLayout(activity)
                layout.orientation = LinearLayout.VERTICAL
                layout.addView(emailInput)
                layout.addView(passwordInput)
                layout.addView(passwordInput2)
                setView(layout)


                setPositiveButton(R.string.registrar
                ) { dialog, _ ->
                    fireBaseAuthRepository
                        .createUserWithEmailAndPassword(
                            emailInput.text.toString(),
                            passwordInput.text.toString(), function
                        )
                    dialog.dismiss()
                }
            }
            builder.create()
        }
        return dialog
    }






}
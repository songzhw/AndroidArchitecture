package ca.six.demo.cleanviper.ext

import android.widget.EditText

fun EditText.stringContent(): String {
    return this.text.toString()
}


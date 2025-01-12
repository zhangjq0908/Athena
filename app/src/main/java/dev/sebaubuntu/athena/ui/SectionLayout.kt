/*
 * SPDX-FileCopyrightText: 2023 Sebastiano Barezzi
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.sebaubuntu.athena.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import dev.sebaubuntu.athena.R

class SectionLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {
    // Views
    private val linearLayout by lazy { findViewById<LinearLayout>(R.id.linearLayout) }
    private val titleTextView by lazy { findViewById<TextView>(R.id.titleTextView) }

    var titleText: CharSequence?
        get() = titleTextView.text
        set(value) {
            titleTextView.text = value
            titleTextView.isVisible = !titleText.isNullOrEmpty()
        }

    init {
        inflate(context, R.layout.section_layout, this)
    }

    fun addListItem(listItem: ListItem) {
        linearLayout.addView(
            listItem,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        )
    }
}

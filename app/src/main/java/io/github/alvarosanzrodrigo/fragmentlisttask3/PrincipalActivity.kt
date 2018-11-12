package io.github.alvarosanzrodrigo.fragmentlisttask3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast

class PrincipalActivity : AppCompatActivity() {

    private lateinit var dl: DrawerLayout
    private lateinit var t: ActionBarDrawerToggle
    private lateinit var nv: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        dl = findViewById(R.id.activity_principal)
        t = ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close)
        dl.addDrawerListener(t)
        t.syncState()

        nv = findViewById(R.id.nv)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title= "Subjects"
        setListeners()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).apply {
            this.inflate(R.menu.dots_menu, menu)
        }
        return super.onCreateOptionsMenu(menu)
    }

    internal fun setListeners(){
        nv.setNavigationItemSelectedListener { item ->
            val id = item.itemId
            when (id) {
                R.id.subjects -> {
                    supportActionBar?.title = "Subject"
                    dl.closeDrawers()
                    true
                }
                R.id.notifications -> {
                    supportActionBar?.title = "Notifications"
                    dl.closeDrawers()
                    true
                }
                R.id.grades -> {
                    supportActionBar?.title = "Grades"
                    dl.closeDrawers()
                    true
                }
                R.id.teachers -> {
                    supportActionBar?.title = "Teachers"
                    dl.closeDrawers()
                    true
                }
                R.id.communities -> {
                    supportActionBar?.title = "Communities"
                    dl.closeDrawers()
                    true
                }

                else -> true
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        when (id) {
            R.id.logout -> {
                Toast.makeText(this, "LogOut", Toast.LENGTH_SHORT).show()
            }
        }

        return if (t.onOptionsItemSelected(item)) true else super.onOptionsItemSelected(item)

    }
}

package com.example.mykotlinapplication.objpassing

import java.io.Serializable

public class Emp(var id: Int, var name: String, var field: String, var selery: Int, var address: String) :
    Serializable {
    override fun toString(): String {
        return "Emp(id=$id, name='$name', field='$field', selery=$selery, address='$address')"
    }
}

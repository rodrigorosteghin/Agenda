package com.example.agenda.dao

import androidx.room.*
import com.example.agenda.tablas.Personal

@Dao
interface   PersonalDao {

    @Query("SELECT * FROM Personal")
    suspend fun getAll():List<Personal>

    @Query("SELECT * FROM Personal WHERE idEmpleado = :id")
    suspend fun getById(id:Long):Personal

    @Query("SELECT * FROM Personal WHERE nombre LIKE '%'|| :name || '%' OR apellido LIKE '%'|| :name || '%'")
    suspend fun getByName(name:String):List<Personal>

    @Insert
    suspend fun insert(personas:Personal):Long

    @Insert
    suspend fun insert(personas:List<Personal>):List<Long>

    @Update
    suspend fun update(personal:Personal):Int

    @Delete
    suspend fun delete(personal:Personal):Int
}
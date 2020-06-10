package com.example.basemvvm.common

import android.Manifest

object Constants {
    fun getPermissions(): Array<String> {
        val permissions = arrayListOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.BLUETOOTH,
            Manifest.permission.BLUETOOTH_ADMIN
        )
        return permissions.toTypedArray()
    }
}
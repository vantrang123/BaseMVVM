package com.example.basemvvm.ui.main

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import com.example.basemvvm.R
import com.example.basemvvm.ui.base.BaseActivity
import com.example.basemvvm.viewmodel.main.IMainViewModel

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
class MainActivity : BaseActivity<IMainViewModel>() {
    private val bluetoothAdapter: BluetoothAdapter? by lazy(LazyThreadSafetyMode.NONE) {
        val bluetoothManager =
            getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        bluetoothManager.adapter
    }
    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.onPermissionStateChange.observe(this, Observer {
            onCheckBluetooth()
        })

        viewModel.onCheckPermissionStateChange {
            if (!it) {
                onCheckBluetooth()
                return@onCheckPermissionStateChange
            }
        }

    }

    private fun onCheckBluetooth() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            enableBluetooth()
        } else {
            finish()
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun enableBluetooth() {
        bluetoothAdapter?.let {
            if (it.isDisabled) {
                val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                startActivityForResult(
                    enableBtIntent,
                    REQUEST_BLUETOOTH
                )
            } else {
            }
            return
        }
    }

    private val BluetoothAdapter.isDisabled: Boolean
        get() = !isEnabled

    companion object {
        private const val REQUEST_BLUETOOTH = 222
    }
}
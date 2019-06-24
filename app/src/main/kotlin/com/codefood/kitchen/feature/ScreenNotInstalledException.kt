package com.codefood.kitchen.feature

class ScreenNotInstalledException(name: String) : Throwable("Screen $name not installed.")
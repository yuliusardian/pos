@echo off
del model\*.class
del view\*.class
del *.class

javac AplikasiPenjualan.java
java AplikasiPenjualan

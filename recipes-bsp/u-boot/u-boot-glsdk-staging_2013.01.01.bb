require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for TI devices supported by the GLSDK product"

PR = "r0+gitr${SRCPV}"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://git.omapzoom.org/repo/u-boot.git;protocol=git;branch=${BRANCH}"

BRANCH = "p-ti-u-boot-2013.04"

SRCREV = "53fa2ada34fb4b3be716a05084762b776282e04e"

SPL_BINARY = "MLO"
SPL_UART_BINARY = "u-boot-spl.bin"

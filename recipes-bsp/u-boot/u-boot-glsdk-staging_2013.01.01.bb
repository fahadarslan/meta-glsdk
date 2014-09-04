require u-boot-ti.inc

DESCRIPTION = "u-boot bootloader for TI devices supported by the GLSDK product"

PR = "r0+gitr${SRCPV}"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://git.omapzoom.org/repo/u-boot.git;protocol=git;branch=${BRANCH}"

BRANCH = "p-ti-u-boot-2013.04"

SRCREV = "388760595f2babf88334aac9de4560bbca5c51b5"

SPL_BINARY = "MLO"
SPL_UART_BINARY = "u-boot-spl.bin"

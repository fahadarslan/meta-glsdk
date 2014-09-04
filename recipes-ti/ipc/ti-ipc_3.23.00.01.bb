DESCRIPTION = "TI Inter Process Communication (IPC) Mechanisms (for Uni- and Multi- Processor Configurations)"
HOMEPAGE = "https://git.ti.com/ipc/pages/Home"
LICENSE = "BSD"

PR = "r2"

LIC_FILES_CHKSUM = "file://${S}/ipc-linux.mak;beginline=1;endline=30;md5=abd112f156e5eb9b0f3e202e48747f9a"

DEPENDS += "virtual/kernel"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PLATFORM_omap5-evm = "OMAP54XX"
PLATFORM_dra7xx-evm = "DRA7XX"

inherit autotools pkgconfig

SRC_URI = "git://git.ti.com/ipc/ipcdev.git;protocol=git"

SRCREV = "1ab09c29cef941a1433f9d51117cbe97d1d39508"

S = "${WORKDIR}/git"

FILESEXTRAPATHS_prepend := "${THISDIR}:"

do_configure() {
	sed -i -e "s#^KERNEL_INSTALL_DIR =.*#KERNEL_INSTALL_DIR = ${STAGING_KERNEL_DIR}#" ${S}/products.mak
	sed -i -e "s#^TOOLCHAIN_INSTALL_DIR =.*#TOOLCHAIN_INSTALL_DIR = ${TOOLCHAIN_PATH}#" ${S}/products.mak
	sed -i -e "s#^TOOLCHAIN_LONGNAME =.*#TOOLCHAIN_LONGNAME = arm-linux-gnueabihf#" ${S}/products.mak
	sed -i -e "s#^PLATFORM =.*#PLATFORM = ${PLATFORM}#" ${S}/products.mak
	sed -i -e "s#^DESTDIR =.*#DESTDIR = /usr#" ${S}/products.mak

	make -f ${S}/ipc-linux.mak config
}

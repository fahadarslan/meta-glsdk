DESCRIPTI-TSPAON = "Firmware for IPU "
HOMEPAGE = "http://downloads.ti.com/dsps/dsps_public_sw/gfxsdk"
LICENSE = "TI-TSPA"

SRC_URI = "http://downloads.ti.com/dsps/dsps_public_sw/glsdk/ipumm/3_00_04_02/exports/ipumm-dra7xx-evm-3.00.04.02.tar.gz;protocol=http"

LIC_FILES_CHKSUM = "file://MMIP-${PV}-Manifest.doc;md5=64ca6f9d7e5243b8a4084eb918a543bc"

PR = "r0"

COMPATIBLE_MACHINE = "dra7xx-evm"

SRC_URI[md5sum] = "da04c03b0fd57901e8283afa80f81379"
SRC_URI[sha256sum] = "0b26fd13f9c318b52c18b9bff56862ef1f58a768b19285b87c035e65bc828ddc"

S = "${WORKDIR}/ipumm-${MACHINE}-${PV}"

TARGET = "dra7-ipu2-fw.xem4"

do_install() {
        mkdir -p ${D}/lib/firmware
        cp ${S}/firmware/${TARGET} ${D}/lib/firmware/${TARGET}
}

FILES_${PN} += "/lib/firmware/${TARGET}"

DESCRIPTI-TSPAON = "Firmware for IPU "
HOMEPAGE = "http://downloads.ti.com/dsps/dsps_public_sw/gfxsdk"
LICENSE = "TI-TSPA"

SRC_URI = "ftp://swubn01.india.ti.com/AragoRepo/glsdk/ipumm/ipumm-dra7xx-evm-3.00.05.01.tar.gz;protocol=ftp"

LIC_FILES_CHKSUM = "file://MMIP-${PV}-Manifest.doc;md5=f65ebb35a5f3f9fa266c1e0814387ec0"

PR = "r1"

COMPATIBLE_MACHINE = "dra7xx-evm"

SRC_URI[md5sum] = "68df72c1887263470260ee58f702f2e5"
SRC_URI[sha256sum] = "4c132d601a0d8179909c910213dce368a534e747071909e59739db2352774661"

S = "${WORKDIR}/ipumm-${MACHINE}-${PV}"

TARGET = "dra7-ipu2-fw.xem4"

do_install() {
        mkdir -p ${D}/lib/firmware
        cp ${S}/firmware/${TARGET} ${D}/lib/firmware/${TARGET}
}

FILES_${PN} += "/lib/firmware/${TARGET}"

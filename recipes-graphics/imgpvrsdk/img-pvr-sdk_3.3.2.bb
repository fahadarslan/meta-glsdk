DESCRIPTION = "Imagination PowerVR SDK"
HOMEPAGE = "http://community.imgtec.com/developers/powervr/installers"
LICENSE = "TI-TSPA"
LIC_FILES_CHKSUM = "file://LegalNotice.txt;md5=d9c0ca03b9845110090435a33eec4a33"

SRC_URI = "git://git.ti.com/glsdk/img-pvr-sdk.git;protocol=git"
SRCREV = "edbd108d1582560429192dc0221f0a8fddea0928"

PR = "r3"

S = "${WORKDIR}/git"

do_install () {
    oe_runmake install DESTDIR=${D}
}

INHIBIT_PACKAGE_STRIP = "1"

INSANE_SKIP_${PN} += "dev-so"

FILES_${PN} += "/opt/img-powervr-sdk/Examples/Advanced/OGLES2ChameleonMan /opt/img-powervr-sdk/Examples/Advanced/OGLES2Coverflow /opt/img-powervr-sdk/Examples/Advanced/OGLES2ExampleUI /opt/img-powervr-sdk/Examples/Advanced/OGLES2Navigation /opt/img-powervr-sdk/PVRHub/* /opt/img-powervr-sdk/PVRScopeDeveloper/*"

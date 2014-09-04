require wayland.inc

inherit autotools pkgconfig

# We need wayland-native for the wayland-scanner utility
BBCLASSEXTEND = "native"

DEPENDS_virtclass-native = "expat-native libffi-native"
DEPENDS = "expat libffi wayland-native"

EXTRA_OECONF_virtclass-native = "--disable-documentation"
EXTRA_OECONF = "--disable-documentation --disable-scanner"

PR = "r3"

COMPATIBLE_MACHINE = "dra7xx-evm"

SRC_URI = "git://anongit.freedesktop.org/wayland/wayland;protocol=git"
SRC_URI_append_class-native = " file://just-scanner.patch"

S = "${WORKDIR}/git"

FILESEXTRAPATHS_prepend := "${THISDIR}:"

SRCREV = "2c3dbb89031f120fb191492634e53a583f99d57d"

# Wayland installs a M4 macro for other projects to use, which uses the target
# pkg-config to find files.  Replace pkg-config with pkg-config-native.
do_install_append_class-native() {
  sed -e 's,PKG_CHECK_MODULES(.*),,g' \
      -e 's,$PKG_CONFIG,pkg-config-native,g' \
      -i ${D}/${datadir}/aclocal/wayland-scanner.m4
}


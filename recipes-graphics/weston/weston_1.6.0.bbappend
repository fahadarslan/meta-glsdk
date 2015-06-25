PACKAGECONFIG[wayland] = "--enable-wayland-compositor,--disable-wayland-compositor,libgbm"

SRC_URI_append  = "file://weston.ini \
"

PR_append = "-arago9"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

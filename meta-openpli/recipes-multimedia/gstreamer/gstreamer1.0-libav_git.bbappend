DEFAULT_PREFERENCE = "1"

include gstreamer1.0-git-version.inc

SRC_URI_remove = "git://anongit.freedesktop.org/gstreamer/gst-libav;branch=1.8;name=base"
SRC_URI_prepend = "git://anongit.freedesktop.org/gstreamer/gst-libav;branch=master;name=base "

SRCREV_base = "c39e08dfb531091a68577197a6f74df440f7ca99"

DEPENDS =+ "ffmpeg"

PACKAGECONFIG = "libav"

CFLAGS_append = " -Wno-deprecated-declarations "

LIBAV_EXTRA_CONFIGURE_COMMON_ARG =+ " \
  ${@bb.utils.contains('TARGET_FPU', 'soft', ' --disable-mipsfpu', ' --enable-mipsfpu', d)} \
  --disable-mipsdsp \
  --disable-mipsdspr2 \
"

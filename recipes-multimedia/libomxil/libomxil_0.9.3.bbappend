EXTRA_OECONF := "${@oe_filter_out('--disable-ffmpegcomponents', '${EXTRA_OECONF}', d)}"
EXTRA_OECONF += "--enable-ffmpegcomponents "


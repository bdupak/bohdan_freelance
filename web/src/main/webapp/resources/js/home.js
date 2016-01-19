$(document).ready(function() {
	$('*[data-tooltip="yes"]').tooltip();

	$('#fullpage').fullpage({
		menu : '.side-navigation',
		lockAnchors : false,
		anchors : [ 'main', 'customer', 'developer' ]
	});

	$('ul.side-navigation > li').click(function() {
		var arr = $(this).find('> a');
		$(arr).each(function() {
			location = $(this).attr('href');
		});
	});

});
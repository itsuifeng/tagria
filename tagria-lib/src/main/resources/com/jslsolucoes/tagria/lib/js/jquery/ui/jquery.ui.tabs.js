(function($) {
	$.widget("bs.tab", {
		options: {
			
		},
		_create: function() {
			var self = this;
			var tabPanel = self.element;
			
			var firstTab = $('iframe:first',tabPanel);
			firstTab.attr('src',firstTab.attr('data-url'));
		
			$('li',tabPanel).click(function(){
				var iframe = $('iframe',$('a',this).attr('href'));
				if($(this).hasClass('ui-tabs-reload-on-select')||iframe.attr('src')==''){
					iframe.attr('src',iframe.attr('data-url'));	
				}
			});
		}
	});
})(jQuery);

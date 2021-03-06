(function($) {
	$.widget("bs.tab", {
		options: {
			
		},
		_create: function() {
			var self = this;
			var panel = self.element;
			
			self._active('iframe.active');
			self._active('iframe:first');
		
			$('li',panel).click(function(){
				var iframe = $('iframe',$('a',this).attr('href'));
				if($(this).hasClass('ui-tabs-reload-on-select')||iframe.attr('src')==''){
					iframe.attr('src',iframe.attr('data-url'));	
				}
			});
		},
		_active: function(selector){
			var self = this;
			var panel = self.element;
			var iframe = $(selector,panel);
			iframe.attr('src',iframe.attr('data-url'));
		}
	});
})(jQuery);

(function($) {
	$.widget("bs.iframe", {
		options: {
			interval : 1000
		},
		_create: function() {
			var self = this;
			var iframe = self.element;
			self.minHeight = $(document).height() - iframe.offset().top;
			iframe.load(function(){
				self._reset();
				self._resize();
			});
			setInterval(function(){
				self._resize();
			},self.options.interval);
		},
		_reset : function () {
			var self = this;
			var iframe = self.element;
			iframe.css('height',0 + 'px');
		},
		_resize : function (){
			var self = this;
			var iframe = self.element;
			if(iframe && iframe.contents() && iframe.contents().outerHeight()){
				var height = iframe.contents().outerHeight();
				if(height < self.minHeight){
					height = self.minHeight;
				}
				iframe.css('height', height +'px');
			}
		}
	});
})(jQuery);





(function($) {
	$.widget("bs.autoComplete", {
		options: {
			minLength : 0,
			source : '',
			display : function (item) {
				return 'Please implement display method';
			},
			select: function( item ) {				 						
	       		
			},
			resultsNotFound : 'Não foram encontrados resultados'
		},
		_create: function() {
			var self = this;
			var input = self.element;
			self._buildMenu();
			input.keyup(function(){
				if($(this).val().length >= self.options.minLength){
					self._search();
				}
			}).blur(function(){
				self._hideMenu();
			});
		},
		_showMenu: function() {
			var self = this;
			self.ul.fadeIn();
		},
		_hideMenu: function() {
			var self = this;
			self.ul.fadeOut();
		},
		_buildMenu : function () {
			var self = this;
			var input = self.element;
			self.ul = $(document.createElement('ul')).addClass('list-group').hide();
			input.after(self.ul);
		},
		_search: function(){
			var self = this;
			var input = self.element;
			$.ajax({
				type : 'post',
				url : self.options.source,
				dataType : 'json',
				data : {
					term : input.val()
				},
				success : function(data, textStatus, XMLHttpRequest){
					if(data){
						self._renderItems(data);
					} else {
						self._noResults();
					}
				}
			})
		},
		_noResults: function() {
			var self = this;
			var auto = self.element;
			self.ul.html('');
			var li = $(document.createElement('li')).addClass('list-group-item').
					append(self.options.resultsNotFound).appendTo(self.ul);
		},
		_renderItems: function(data){
			var self = this;
			var input = self.element;
			self.ul.html('');
			$.each(data.list,function(key,item){
				var display = self.options.display(item);
				var li = $(document.createElement('li')).addClass('list-group-item').
					append(display).hover(function(){
							$(this).addClass('active');
						},function(){
							$(this).removeClass('active');
					}).click(function(){
						input.val(display);
						self.options.select(item);
						self._hideMenu();
					}).appendTo(self.ul);
			});
			self._showMenu();
		}
	});
})(jQuery);
(function($) {
	$.widget("bs.grid", {
		options : {
			url : '',
			queryString : '',
			exporter : ''
		},
		_create : function() {
			var self = this;
			self._collapsable();
			self._pagination();
			self._resultsPerPage();
			self._exportation();
			self._search();
			self._checkAll();
		},
		_checkAll : function() {
			var self = this;
			var grid = self.element;
			$('.bs-grid-check-all', grid).on('click.grid',function(event){
				if($(this).prop('checked')) {
					$(':checkbox', grid).prop('checked',true);
				} else {
					$(':checkbox', grid).prop('checked',false);
				}
			});
		},
		_search : function() {
			var self = this;
			var grid = self.element;
			$('.bs-grid-search', grid).on('keydown.grid',function(event){
				if(event.keyCode==13 && $(this).val()!=''){
					window.location = self.options.url + '?search=true&term=' + encodeURIComponent($(this).val());
				}
			});
		},
		_collapsable : function (){
			var self = this;
			var grid = self.element;
			$('.bs-grid-column-collapsable', grid).each(function() {
				$(this).popover({
			       content : $('.bs-grid-column-collapsable-content', this).html(),
			       html : true,
			       placement : 'bottom',
			       container : 'body'
			    });
			});
		},
		_pagination : function (){
			var self = this;
			var grid = self.element;
			$('.bs-grid-paginate-item', grid).on('click.grid',function(){
				$('.bs-grid-paginate-item.active').removeClass('active');
				$(this).addClass('active');
				self._paginate(false);
			});
		},
		_resultsPerPage : function() {
			var self = this;
			var grid = self.element;
			$('.bs-grid-results-per-page-item', grid).on('click.grid',function(){
				$('.bs-grid-results-per-page-item.active').removeClass('active');
				$(this).addClass('active');
				self._paginate(true);
			});
		},
		_paginate : function (reset) {
			var self = this;
			var grid = self.element;
			var resultsPerPage = parseInt($('.bs-grid-results-per-page-item.active').text());
			var page = parseInt($('.bs-grid-paginate-item.active').text());
			if(reset) {
				page = 1;
			}
			window.location = self.options.url + '?page='+page+'&resultsPerPage='+resultsPerPage + '&' +  self.options.queryString;			
		},
		_exportation : function() {
			var self = this;
			var grid = self.element;
			$('.bs-grid-export-pdf',grid).on('click.grid',function(){
				self._export('pdf');
			});
			
			$('.bs-grid-export-csv',grid).on('click.grid',function(){
				self._export('csv');
			});
			
			$('.bs-grid-export-xml',grid).on('click.grid',function(){
				self._export('xml');
			});
			
			$('.bs-grid-export-excel',grid).on('click.grid',function(){
				self._export('xls');
			});
		},
		_export : function(type) {
			var self = this;
			var grid = self.element;
			$('.bs-grid-export-type',grid).val(type);
			$('.bs-grid-export-json',grid).val(self._json());
			$('.bs-grid-export-form',grid).submit();
		},
		_json : function(){
			
			var self = this;
			var grid = self.element;
			
			var header = new Array();
			$('table:first > thead > tr > th:visible.bs-grid-column-exportable',grid).each(function(){
				header.push({
					align : ($(this).hasClass('text-left') ? 'left' : $(this).hasClass('text-right') ? 'right' : 'center'),
					content : $.trim($(this).text())
				});
			});
			
			var body = new Array();
			$('table:first > tbody > tr:visible',grid).each(function(){
				var column = new Array();
				$('td:visible.bs-grid-column-exportable',this).each(function(){
					column.push({
						align : ($(this).hasClass('text-left') ? 'left' : $(this).hasClass('text-right') ? 'right' : 'center'),
						content : $.trim($(this).text())
					});
				});
				body.push({columns : column});
			});
			return "{ title : '"+$('.panel-heading',grid).text()+"', headers : "+JSON.stringify(header)+", rows : "+JSON.stringify(body)+"}";
		}
	});
})(jQuery);

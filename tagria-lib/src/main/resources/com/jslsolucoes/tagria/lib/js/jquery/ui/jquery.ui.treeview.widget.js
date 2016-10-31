(function($) {
	$.widget("bs.treeview", {
		options : {
			multiple : false,
			url : '',
			folderIcon : '',
			fileIcon : '',
			name : ''
		},
		_create : function() {
			var self = this;
			var treeview = self.element;

			$('.bs-treeview-view', treeview).jstree({
				core : {
					data : {
						url : self.options.url,
						data : function(node) {
							return {
								id : node.id,
								rel : (node.li_attr ? node.li_attr.rel : '#')
							};
						}
					},
					multiple : self.option.multiple,
					themes : {
						dots : false
					}
				},
				types : {
					folder : {
						icon : self.options.folderIcon
					},
					file : {
						icon : self.options.fileIcon
					}
				},
				plugins : [ 'types' ]
			}).on('changed.jstree',function(evt, data) {
				if(self.options.name != null){
					$(':hidden', treeview).remove();
					var selected = new Array();
					$.each($('.bs-treeview-view', treeview).jstree(true).get_selected('full', true),function(index) {
						treeview.append(
					    		$(document.createElement('input')).attr('type','hidden')
					    		.attr('name',self.options.name.replace(/\[\]/g,"["+index+"]")).val(this.id));
						selected.push(this.text);
					});
					$('.bs-treeview-text', treeview).html(selected.join (' - '));
				}
			});

			$('.bs-treeview-clear', treeview).click(function() {
				self._clear();
			});
		},
		_clear : function() {
			var self = this;
			var treeview = self.element;
			var view = $('.bs-treeview-view', treeview);
			view.jstree('deselect_all');
			view.jstree('close_all');
			$('.bs-treeview-text', treeview).html('');
			$(':hidden', treeview).remove();
		}
	});
})(jQuery);
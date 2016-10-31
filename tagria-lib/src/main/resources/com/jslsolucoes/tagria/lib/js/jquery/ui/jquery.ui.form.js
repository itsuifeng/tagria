(function($) {
	$.widget("bs.form", {
		options: {
			validation : ''
		},
		_create: function() {
			var self = this;
			var form = self.element;  
			
			$("input,select",form).on('keydown.form',function(e) {
				if(e.keyCode==13) {
					self._validateAndSubmit();
        		}
			});
		    
			var submit = $('a.btn[data-type=submit]',form);
			var target = submit.attr('data-target');
			if(target){
				submit = $('a.sure',target);
			}
			submit.on('click.form',function(){
		    	self._scrollToTop();
				self._validateAndSubmit();
		    }); 
		},
		_scrollToTop : function () {
			window.parent.parent.scrollTo(0,0);
			window.parent.scrollTo(0,0);
			window.scrollTo(0,0);
		},
		_block : function () {
			var self = this;
			var form = this.element;
			$('a.btn[data-type=submit]',form).addClass("disabled");
		},
		_unblock : function () {
			var self = this;
			var form = this.element;
			$('a.btn[data-type=submit]',form).removeClass("disabled");
		},
		_clean : function() {
			var self = this;
			var form = self.element;
			$('.has-error',form).removeClass('has-error');
			$('.bs-treeview-has-error',form).removeClass('bs-treeview-has-error');
			$('.bs-form-empty-field',form).hide();
			$('.bs-form-validation-errors',form).hide();
		},
		_validateAndSubmit : function() {
			var self = this;
			var form = this.element;
			self._clean();
			self._block();
			
			if(!self._hasRequiredFieldBlank()){
				if(self.options.validation == '') {
					self._submit();
				} else {
					var data = new Array();
					data.push({name:'_format',value : 'json'});
					$(':input[name]:not(:checkbox:not(:checked),:radio),:input[name]:radio:checked',form).each(function(){
						data.push({name: $(this).attr('name'), value: $(this).val()});
					});
									
					$.ajax({ 
				     	url:       self.options.validation, 
				        type:      'post',
				        data : data,
				        dataType : 'json',
				        success:  function(data){
							if(data.errors && data.errors != '') {
								$('.bs-form-validation-errors',form).html(data.errors).show();
								self._unblock();
							} else {
								self._submit();
							}					           	
				        },
				        error : function (jqXHR, textStatus, errorThrown) {
				        	self._unblock();
				        }
				    });
				}
			} else {
				self._unblock();
			}
		},
        _submit : function() {
        	var self = this;
        	self.element[0].submit();
        },
		_hasRequiredFieldBlank: function() {
			 var self = this;
			 var form = self.element;
			 var empty = false;
         	 $('.bs-input-required:visible',form).each(function(){
         		if($(this).val() == ''){
         			$(this).parent().addClass('has-error');
         			empty = true;
         		}
         	 });
         	 
         	$(".bs-treeview",form).each(function(){
				if($(this).hasClass("bs-treeview-required")){
					if($(':hidden',this).size() == 0){
         				$(this).addClass('bs-treeview-has-error');
         				empty = true;
					}
				}						
			});
         	 
         	 if(empty){
         		$('.bs-form-empty-field',form).show();
         	 }
        	 return empty;
		}
	});
})(jQuery);
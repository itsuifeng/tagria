(function($) {
	$.widget("bs.form", {
		options: {
			validation : '',
			invalid : {
				email : 'Invalid email',
				max : 'Must not be greater than',
				min : 'Must not be less than'
			}
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
			$('.bs-syntax-highlight-has-error',form).removeClass('bs-syntax-highlight-has-error');
			$('.bs-form-empty-field',form).hide();
			$('.bs-form-validation-errors',form).hide();
		},
		_validateAndSubmit : function() {
			var self = this;
			var form = this.element;
			self._clean();
			self._block();
			
			if(!self._hasRequiredFieldBlank() && !self._hasValidationError()){
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
        	var form = this.element;
        	$('.disabled',form).attr('disabled',false);
        	
        	if(form.attr('target') != '_self' || !$('form').attr('action').indexOf('javascript:')){
        		self._unblock();
        	}
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
         	 
         	$(".bs-treeview-required",form).each(function(){
				if($(':hidden',this).size() == 0){
     				$(this).addClass('bs-treeview-has-error');
     				empty = true;
				}						
			});
         	
         	
         	$(".bs-syntax-highlight-required",form).each(function(){
				if($(this).val() == ''){
					$(this).next('.CodeMirror').addClass('bs-syntax-highlight-has-error');
     				empty = true;
				}						
			});
         	 
         	 if(empty){
         		$('.bs-form-empty-field',form).show();
         	 }
        	 return empty;
		},
		_hasValidationError : function() {
			var self = this;
			var form = self.element;
			var error = false;
			$('input[type=email]',form).each(function(){
				if(!/[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?/.test( $(this).val() )){
					$(this).parent().addClass('has-error');
					$(this).popover({
					       content : self.options.invalid.email,
					       html : true,
					       placement : 'bottom',
					       container : 'body',
					       trigger : 'manual'
					})
					.popover('show');	
					error = true;
				} else {
					$(this).popover('destroy');
		        }
			});
			
			$('input[type=number][max]',form).each(function(){
				if(parseInt($(this).val()) > parseInt($(this).attr("max"))){
					$(this).parent().addClass('has-error');
					$(this).popover({
					       content : self.options.invalid.max + ' ' + $(this).attr("max"),
					       html : true,
					       placement : 'bottom',
					       container : 'body',
					       trigger : 'manual'
					}).popover('show');
					error = true;
				} else {
					$(this).popover('destroy');
		        }
			});
			
			$('input[type=number][min]',form).each(function(){
				if(parseInt($(this).val()) < parseInt($(this).attr("min"))){
					$(this).parent().addClass('has-error');
					$(this).popover({
					       content : self.options.invalid.min + ' ' + $(this).attr("min"),
					       html : true,
					       placement : 'bottom',
					       container : 'body',
					       trigger : 'manual'
					}).popover('show');
					error = true;
				} else {
					$(this).popover('destroy');
		        }
			});
			
			return error;
		}
	});
})(jQuery);
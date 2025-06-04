com.hybris.table.TableCell = zk.$extends(zk.Widget, {

	_sticky: false,

	setSticky: function (sticky) {
		this._sticky = sticky;
		if (this.desktop) {
			var cell = jq(this.$n());
			if (sticky) {
				cell.addClass(this.$s('sticky'));
				var _parentTable = this.parent.getParentTable();
				if(_parentTable && typeof(_parentTable.getScrollStylingObject) == "function" && typeof(_parentTable.getScroll) == "function"){
					cell.css(_parentTable.getScrollStylingObject(typeof(_parentTable.getScroll) === "function" ? _parentTable.getScroll().left : 0, 0));
				}
			}
			else {
				cell.removeClass(this.$s('sticky'));
				cell.removeAttr("style");
			}
            this.parent.updateRowContents();
			this.fire('onSticky', {sticky: sticky});
		}
	},

	isSticky: function() {
		return this._sticky;
	},

	isHeader: function () {
		return this.parent.parent.$instanceof(com.hybris.table.TableHeader);
	},

	getZclass: function () {
		var zcls = this._zclass != null ? this._zclass : 'y-' + this.widgetName;
		if (this.isHeader()) {
			return zcls + "-header";
		}
		else {
			return zcls;
		}
	},

	domClass_: function (no) {
		var sc = this.$supers('domClass_', arguments);
		if (this.isSticky()) {
			sc = this.$s("sticky") + ' ' + sc;
		}
		return sc;
	},

	updateTableContents: function(){
		var _parentTable = this.parent.getParentTable();
		if(_parentTable) {
			_parentTable.requestStickyTableUpdate(); 
		};
	},

	redraw: function (out) {
		if (this.isHeader()) {
			out.push('<th ', this.domAttrs_() + '>');
		}
		else {
			out.push('<td ', this.domAttrs_() + '>');
		}
		for (var w = this.firstChild; w; w = w.nextSibling) {
			w.redraw(out);
		}
		if (this.isHeader()) {
			out.push('</th>');
		}
		else {
			out.push('</td>');
		}
		var _tableCellID = this.uuid, _tableCell = this;

		window.setTimeout(function(){
			if($("#" + _tableCellID).find(".yw-collection-show-more-container").index() >= 0){
				$("#" + _tableCellID + " .yw-collection-show-more-container").click(function(){
				    var _currentClass = $(this).parent().attr('class'),
				        _container = $(this).parent(),
				    	_checkClass = function(){
				    		if(_container.attr('class') != _currentClass){
				    			clearInterval(_checkInterval);
				    			_tableCell.updateTableContents();
				    		}
				    	};
				    	const _checkInterval = setInterval(_checkClass, 150);
				    window.setTimeout(function(){
				    	clearInterval(_checkInterval);
				    }, 1200);
				});
			}
		}, 100);
	}

});

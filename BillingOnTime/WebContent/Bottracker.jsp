<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!doctype html> 
<html lang="en">
<head>    
	<meta charset="utf-8" />    
	<title>jQuery UI Droppable - Simple photo manager</title>
	<link rel="stylesheet" href="scripts/jquery-ui.css" />
	<script src="scripts/jquery-1.8.3.js"></script>
	<script src="scripts/jquery-ui.js"></script>      
	 <link rel="stylesheet" href="/resources/demos/style.css" />    
	 <style>    
	 #gallery { float: left; width: 65%; min-height: 12em; } * html 
	 #gallery { height: 12em; } /* IE6 */    
	 .gallery.custom-state-active { background: #eee; }    
	 .gallery li { float: left; width: 96px; padding: 0.4em; margin: 0 0.4em 0.4em 0; text-align: center; }    
	 .gallery li h5 { margin: 0 0 0.4em; cursor: move; }    
	 .gallery li a { float: right; }    
	 .gallery li a.ui-icon-zoomin { float: left; }    
	 .gallery li img { width: 100%; cursor: move; }     
	 #trash { float: right; width: 32%; min-height: 18em; padding: 1%;} * html 
	 #trash { height: 18em; } /* IE6 */    
	 #trash h4 { line-height: 16px; margin: 0 0 0.4em; }    
	 #trash h4 .ui-icon { float: left; }    
	 #trash .gallery h5 { display: none; }    
	</style>    
	<script>    
	$(function() {        

	// there's the gallery and the trash        
	var $gallery = $( "#gallery" ),            
	$trash = $( "#trash" );         


	// let the gallery items be draggable    
	$( "li", $gallery ).draggable({            
		cancel: "a.ui-icon", 										// clicking an icon won't initiate dragging         
		revert: "invalid", 											// when not dropped, the item will revert back to its initial position            
		containment: "document", helper: "clone", cursor: "move" });

	// let the trash be droppable, accepting the gallery items        
	$trash.droppable({ 
	accept: "#gallery > li",
	activeClass: "ui-state-highlight",
	drop: function( event, ui ) {deleteImage( ui.draggable );}});

	// let the gallery be droppable as well, accepting items from the trash  
	$gallery.droppable({
	accept: "#trash li",
	activeClass: "custom-state-active",
	drop: function( event, ui ) {recycleImage( ui.draggable );}});

	// image deletion function  
	var recycle_icon = "<a href='link/to/recycle/script/when/we/have/js/off' title='Recycle this image' class='ui-icon ui-icon-refresh'>Recycle image</a>";
		function deleteImage( $item ) {
			$item.fadeOut(function() {
				var $list = $( "ul", $trash ).length ?
				$( "ul", $trash ) :
				$( "<ul class='gallery ui-helper-reset'/>" ).appendTo( $trash );

			$item.find( "a.ui-icon-trash" ).remove();
			$item.append( recycle_icon ).appendTo( $list ).fadeIn(function() {
						$item
						.animate({ width: "48px" })
						.find( "img" )
							.animate({ height: "36px" });
						});
					});
				}     

		// image recycle function 
		var trash_icon = "<a href='link/to/trash/script/when/we/have/js/off' title='Delete this image' class='ui-icon ui-icon-trash'>Delete image</a>";
		function recycleImage( $item ) {
			$item.fadeOut(function() {
				$item
					.find( "a.ui-icon-refresh" )
						.remove()
					.end()
					.css( "width", "96px")
					.append( trash_icon )
					.find( "img" )
						.css( "height", "72px" )
					.end()
					.appendTo( $gallery)
					.fadeIn();
				});
		}         



		// image preview function, demonstrating the ui.dialog used as a modal window        
		function viewLargerImage( $link ) {            
			var src = $link.attr( "href" ),                
				title = $link.siblings( "img" ).attr( "alt" )       
				$modal = $( "img[src$='" + src + "']" );

		if ( $modal.length ) {                
			$modal.dialog( "open" );            
		} else {              
			var img = $( "<img alt='" + title + "' width='384' height='288' style='display: none; padding: 8px;' />" )                    
				.attr( "src", src ).appendTo( "body" );             
			setTimeout(function() {                    
				img.dialog({                        
					title: title,                        
					width: 400,                        
					modal: true                    
				});                
			}, 1 );            
		}        
		}        

		// resolve the icons behavior with event delegation        

		$( "ul.gallery > li" ).click(function( event ) {            
			var $item = $( this ),                
			$target = $( event.target );             
			if ( $target.is( "a.ui-icon-trash" ) ) {                
				deleteImage( $item );            
			} else if ( $target.is( "a.ui-icon-zoomin" ) ) {                
				viewLargerImage( $target );            
			} else if ( $target.is( "a.ui-icon-refresh" ) ) {                
				recycleImage( $item );            
			}             
			return false;        
		});    
	});    

	</script>


</head>
<body> 
	<div class="ui-widget ui-helper-clearfix"> 
		<ul id="gallery" class="gallery ui-helper-reset ui-helper-clearfix">    
			<li class="ui-widget-content ui-corner-tr">        
				<h5 class="ui-widget-header">User 1</h5>        
				<!-- <img src="images/high_tatras_min.jpg" alt="The peaks of High Tatras" width="96" height="72" />   -->  
				<a href="images/high_tatras.jpg" title="View larger image" class="ui-icon ui-icon-zoomin">View larger</a>        
				<a href="link/to/trash/script/when/we/have/js/off" title="Delete this image" class="ui-icon ui-icon-trash">Delete image</a>    
			</li>   
			<li class="ui-widget-content ui-corner-tr">        
				<h5 class="ui-widget-header">User 2</h5>        
				<!-- <img src="images/high_tatras2_min.jpg" alt="The chalet at the Green mountain lake" width="96" height="72" />    -->     
				<a href="images/high_tatras2.jpg" title="View larger image" class="ui-icon ui-icon-zoomin">View larger</a>        
				<a href="link/to/trash/script/when/we/have/js/off" title="Delete this image" class="ui-icon ui-icon-trash">Delete image</a>    
			</li>    
			<li class="ui-widget-content ui-corner-tr">        
				<h5 class="ui-widget-header">User 3</h5>        
				<!-- <img src="images/high_tatras3_min.jpg" alt="Planning the ascent" width="96" height="72" /> -->        
				<a href="images/high_tatras3.jpg" title="View larger image" class="ui-icon ui-icon-zoomin">View larger</a>        
				<a href="link/to/trash/script/when/we/have/js/off" title="Delete this image" class="ui-icon ui-icon-trash">Delete image</a>    
			</li>    
			<li class="ui-widget-content ui-corner-tr">        
				<h5 class="ui-widget-header">User 4</h5>        
				<!-- <img src="images/high_tatras4_min.jpg" alt="On top of Kozi kopka" width="96" height="72" /> -->        
				<a href="images/high_tatras4.jpg" title="View larger image" class="ui-icon ui-icon-zoomin">View larger</a>        
				<a href="link/to/trash/script/when/we/have/js/off" title="Delete this image" class="ui-icon ui-icon-trash">Delete image</a>    
			</li>
		</ul> 
		<div id="trash" class="ui-widget-content ui-state-default">    
			<h4 class="ui-widget-header"><span class="ui-icon ui-icon-trash">Trash</span> DeActivate</h4>
		</div> 
	</div>  
</body>
</html>
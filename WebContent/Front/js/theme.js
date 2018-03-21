/*------------------------------------------------------------------
[Table of contents]

- Project:	iSmile - Phones Market HTML/CSS Template
- Version:	1.1
- Author:  Andrey Sokoltsov
- Profile:	http://themeforest.net/user/andreysokoltsov
--*/

(function() {

	"use strict";

	var Core = {

		initialized: false,

		initialize: function() {

			if (this.initialized) return;
			this.initialized = true;

			this.build();

		},

		build: function() {
			
			//Placeholder for IE
			$('input, textarea').placeholder();

			// Page preloader
			this.initPagePreloader();
			
			//Count Down
			this.initCountDown();

			//Setup WOW.js
			this.initScrollAnimations();

			// Pretty Photo Gallery
			this.initPrettyPhoto();

			// Switch grid
			this.gridSwitcher();

			// Slider range
			this.initSliderRange();

			// Tooltip
			this.initTooltip();

			// Load more
			this.loadMore();

			// Search Field Animation
			this.initSearchAnimation();

			// Select product color
			this.selectProductColor();

			// Mobile Menu
			this.mobileMenu();

			// Accordion
			this.initAccordion();

			//Isotope Filter
			this.isotopeFilter();
			
			// bxSlider
			this.initBxSlider();

			// Owl Carousel
			this.initOwlCarousel();
			
			// Main Slider
			this.initMainSlider();
		},

		initPagePreloader: function(options) {
			var $preloader = $('#page-preloader'),
			$spinner = $preloader.find('.spinner-loader');
			$( window ).on('load', function() {
				$spinner.fadeOut();
				$preloader.delay(500).fadeOut('slow');
				window.scrollTo( 0, 0 );
			});
		},

		initCountDown: function(options) {
			var $countdown = $( '.countdown' );
			if($countdown && $countdown.length){
				$countdown.each(function(i) {
					var $countdownItem = $(this);
					
					var endDateData = $countdownItem.data('end-date');
					var themeData = $countdownItem.data('theme');
					var titleDaysData = $countdownItem.data('title-days');
					var titleHoursData = $countdownItem.data('title-hours');
					var titleMinutesData = $countdownItem.data('title-minutes');
					var titleSecondsData = $countdownItem.data('title-seconds');
					
					$countdownItem.dsCountDown({
						endDate: new Date(endDateData),
						theme: themeData,
						titleDays: titleDaysData,
						titleHours: titleHoursData,
						titleMinutes: titleMinutesData,
						titleSeconds: titleSecondsData
					});
				});
			}
		},

		initScrollAnimations: function(options) {
			var scrollingAnimations = true; // Set true for turn on animation
			if(scrollingAnimations){
				new WOW().init();
			}
		},

		initPrettyPhoto: function(options) {
			$("a[data-gal^='prettyPhoto']").prettyPhoto({
				social_tools: false,
			});
		},

		initSliderRange: function(options) {
			$('#price-min').change(function () {
				var val = $(this).val();
				$('#slider-range').slider("values",0,val);
			});

			$('#price-max').change( function() {
				var val2 = $(this).val();
				$('#slider-range').slider("values",1,val2);
			});

			$( "#slider-range" ).slider({
				range: true,
				min: 0,
				max: 1550,
				values: [ 55, 550 ],
				slide: function( event, ui ) {
					$('#price-min').val("$" + ui.values[0]);
					$('#price-max').val("$" + ui.values[1]);
				}
			});
			$('#price-min').val("$" + $('#slider-range').slider("values",0));
			$('#price-max').val("$" + $('#slider-range').slider("values",1));
		},

		initTooltip: function(options) {
			$('[data-toggle="tooltip"]').tooltip();
		},

		loadMore: function(options) {
			$(".more-list").hide();
			$(".load-more").click(function(){
				$(this).next().slideToggle().siblings('div:visible').slideUp();
				$(this).hide();
			});
		},

		initSearchAnimation: function(options) {
			$(".iconSearch").on('click', function(e){
				e.preventDefault();
				$('#search').fadeToggle();
			});			
		},

		selectProductColor: function(options) {
			$(".colors-item").on('click', function(e){
				e.preventDefault();
				$(this).parent('li').toggleClass('active');
			});
		},

		mobileMenu: function(options) {
			$(".toggle-nav-btn .btn-menu").click(function () {
				$(this).parent('div').toggleClass('active');
				$('.b-header-menu').toggle().toggleClass("menu-show");
			});
		},

		initAccordion: function(options) {
			var accordionBox = $('.enable-accordion');
			if(accordionBox && accordionBox.length){
				accordionBox.each(function(i) {
					var $accordion = $(this);

					var heightStyleData = $accordion.data('height-style');
					var collapsibleData = $accordion.data('collapsible');
					var activeData = $accordion.data('active');

					$accordion.accordion({
						heightStyle: heightStyleData,
						collapsible: collapsibleData,
						active: activeData,
					});
				});
			}
		},

		gridSwitcher: function(options) {
			$("#type-of-display li .toogle-view").click(function(e) {
				e.preventDefault();
				$("#type-of-display li .toogle-view").removeClass('active-view');
				$(this).addClass('active-view');
			})

			$("#type-of-display .grid-3").click(function(e) {
				e.preventDefault();
				$(".b-grid").removeClass('b-grid-list');
			})

			$("#type-of-display .grid-list").click(function(e) {
				e.preventDefault();
				$(".b-grid").addClass('b-grid-list');
			})
		},

		isotopeFilter: function(options) {
			// init Isotope
			var $grid = $('.by-brands').isotope();
			
			// filter items on button click
			$('.by-brands-buttons').on( 'click', 'button', function() {
				var filterValue = $(this).attr('data-filter');
				$grid.isotope({ filter: filterValue });
			});
			// change is-checked class on buttons
			$('.by-brands-buttons').each( function( i, buttonGroup ) {
				var $buttonGroup = $( buttonGroup );
				$buttonGroup.on( 'click', 'button', function() {
					$buttonGroup.find('.active').removeClass('active');
					$( this ).addClass('active');
				});
			});
		},

		initBxSlider: function(options) {
			var bxSliderBox = $('.enable-bx-slider');
			if(bxSliderBox && bxSliderBox.length){
				bxSliderBox.each(function(i) {
					var $bx = $(this);

					var pagerCustomData = $bx.data('pager-custom');
					var controlsData = $bx.data('controls');
					var minSlidesData = $bx.data('min-slides');
					var maxSlidesData = $bx.data('max-slides');
					var slideWidthData = $bx.data('slide-width');
					var slideMarginData = $bx.data('slide-margin');
					var pagerData = $bx.data('pager');
					var modeData = $bx.data('mode');
					var infiniteLoopData = $bx.data('infinite-loop');

					$bx.bxSlider({
						pagerCustom: pagerCustomData,
						controls: controlsData,
						minSlides: minSlidesData,
						maxSlides: maxSlidesData,
						slideWidth: slideWidthData,
						slideMargin: slideMarginData,
						pager: pagerData,
						mode: modeData,
						infiniteLoop: infiniteLoopData,
						prevText: (modeData == 'vertical' ? '<span class="fa fa-angle-up"></span>' : '<span class="fa fa-angle-left"></span>'),
						nextText: (modeData == 'vertical' ? '<span class="fa fa-angle-down"></span>' : '<span class="fa fa-angle-right"></span>'),
					});
				});
			}
		},

		initOwlCarousel: function(options) {
			var owlCarouselBox = $('.enable-owl-carousel');
			if(owlCarouselBox && owlCarouselBox.length){
				owlCarouselBox.each(function(i) {
					var $owl = $(this);
					
					var loopData = $owl.data('loop');
					var autoWidthData = $owl.data('auto-width');
					var dotsData = $owl.data('dots');
					var navData = $owl.data('nav');
					var marginData = $owl.data('margin');
					var responsiveClassData = $owl.data('responsive-class');
					var responsiveData = $owl.data('responsive');
					var sliderNext = $owl.data('slider-next');
					var sliderPrev = $owl.data('slider-prev');

					$owl.owlCarousel({
						loop: loopData,
						autoWidth: autoWidthData,
						dots: dotsData,
						nav: navData,
						margin: marginData,
						responsiveClass: responsiveClassData,
						responsive: responsiveData,
					});
					$(sliderNext).click(function(){
						$owl.trigger('next.owl.carousel');
					});
					$(sliderPrev).click(function(){
						$owl.trigger('prev.owl.carousel');
					});
				});
			}
		},

		initMainSlider: function(options) {
			var $mainSlider = $( '.full-width-slider' );
			if($mainSlider && $mainSlider.length){
				$mainSlider.each(function(i) {
					var $proSlider = $(this);

					var widthData = $proSlider.data('width');
					var heightData = $proSlider.data('height');
					var fadeData = $proSlider.data('fade');
					var buttonsData = $proSlider.data('buttons');
					var waitForLayersData = $proSlider.data('wait-for-layers');
					var thumbnailPointerData = $proSlider.data('thumbnail-pointer');
					var touchSwipeData = $proSlider.data('touch-swipe');
					var autoplayData = $proSlider.data('autoplay');
					var autoScaleLayersData = $proSlider.data('auto-scale-layers');
					var visibleSizeData = $proSlider.data('visible-size');
					var forceSizeData = $proSlider.data('force-size');
					var autoplayDelayData = $proSlider.data('autoplay-delay');

					$proSlider.sliderPro({
						width: widthData,
						height: heightData,
						fade: fadeData,
						buttons: buttonsData,
						waitForLayers: waitForLayersData,
						thumbnailPointer: thumbnailPointerData,
						touchSwipe: touchSwipeData,
						autoplay: autoplayData,
						autoScaleLayers: autoScaleLayersData,
						visibleSize: visibleSizeData,
						forceSize: forceSizeData,
						autoplayDelay: autoplayDelayData
					});
				});
			}
		}


	};

	Core.initialize();

})();

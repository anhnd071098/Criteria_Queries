/**
 * @license Copyright (c) 2003-2022, CKSource Holding sp. z o.o. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
    // config.filebrowserImageBrowseUrl = 'http://localhost:8080/ckfinder/ckfinder.html?type=Images&CKEditor=ctn_content&CKEditorFuncNum=3&langCode=vi';
    config.extraPlugins = 'youtube';
    config.youtube_responsive = true;
    config.youtube_osystem = true;
    config.youtube_autoplay = false;
};

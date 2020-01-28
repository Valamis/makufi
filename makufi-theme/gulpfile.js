'use strict';

var gulp = require('gulp')
var del = require('del')
var runSequence = require('run-sequence')
var liferayThemeTasks = require('liferay-theme-tasks')

liferayThemeTasks.registerTasks({
	gulp: gulp,
        pathBuild: 'build-gulp'
})

gulp.storage.set( 'deployPath', 'dist' )
del('build-gulp/css/**/*')

gulp.task('build-theme', function (cb) {
    del(['build-gulp/_css/**/*', 'build-gulp/css/**/*'])
    return runSequence(
        'build:clean',
        'build:base',
        'build:src',
        'build:web-inf',
        'build:hook',
        'build:themelets',
        'build:rename-css-dir',
        'build:prep-css',
        'build:compile-css',
        'build:fix-url-functions',
        'build:move-compiled-css',
        'build:remove-old-css-dir',
        'build:fix-at-directives',
        'build:r2',
//        'build:add-portlet',
        'build:war',
        cb
    )
})

gulp.task('default', [ 'build-theme' ])

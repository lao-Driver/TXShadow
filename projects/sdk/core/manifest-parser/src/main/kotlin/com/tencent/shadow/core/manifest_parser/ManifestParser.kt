package com.tencent.shadow.core.manifest_parser

import java.io.File

/**
 * manifest-parser的入口方法
 *
 * @param xmlFile       com.android.build.gradle.tasks.ManifestProcessorTask任务的输出文件，
 *                      一般位于apk工程的build/intermediates/merged_manifest目录中。
 * @param outputDir     生成文件的输出目录
 * @param packageName   生成类的包名
 * @param packageForR   生成对R.java引用时需要的R文件的包名
 */
fun generatePluginManifest(xmlFile: File, outputDir: File, packageName: String, packageForR: String) {
    val androidManifest = AndroidManifestReader().read(xmlFile)
    val generator = PluginManifestGenerator(packageForR)
    generator.generate(androidManifest, outputDir, packageName)
}
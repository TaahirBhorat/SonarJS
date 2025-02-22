/*
 * SonarQube JavaScript Plugin
 * Copyright (C) 2011-2023 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
import * as url from 'url';
import * as path from 'path';
// replace __dirname in module
const __dirname = url.fileURLToPath(new URL('.', import.meta.url));

/**
 * The local cache for node distributions
 */
export const DOWNLOAD_DIR = path.join(__dirname, '..', 'downloads');

/**
 * Folder where the node runtimes are prepared
 */
export const RUNTIMES_DIR = path.join(__dirname, '..', 'downloads', 'runtimes');

/**
 * Folder where the plugin can use the runtimes and pick them when building JARs
 */
export const TARGET_DIR = path.join(
  __dirname,
  '..',
  '..',
  '..',
  'sonar-plugin',
  'sonar-javascript-plugin',
  'target',
  'node',
);

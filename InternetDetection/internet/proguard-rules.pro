#// Copyright (c) 2014, the Dart project authors.  Please see the AUTHORS file
#// for details. All rights reserved. Use of this source is governed by a
#// BSD-style license that can be found in the LICENSE file.
#
#/// Character codes based on HTML 4.01 character entity names.
#///
#/// For each entity name, e.g., `nbsp`,
#/// a constant with that name prefixed by `$` is defined
#/// for that entity's code point.
#///
#/// The HTML entities include the non-ASCII Latin-1 characters and
#/// symbols, mathematical symbols and Greek litters.
#///
#/// The five characters that are ASCII
#/// are exported from the `ascii.dart` library.
#///
#/// Three names conflict with `ascii.dart`: `$minus`, `$sub` and `$tilde`.
#/// If importing both libraries, these three should be hidden from o
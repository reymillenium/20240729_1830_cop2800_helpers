# Java Helper Classes with Utility Functions

## Helper Package

### Package Content:

- JHArray `v2024.07.29.2242`
- DatabaseHelper `v2024.07.29.0146`
- Datesy `v2024.07.29.2210`
- Rangy `v2024.08.01.0936`
- Mathsy `v2024.08.01.2158`
- Terminus `v2024.07.29.2234`
- TFile `v2024.07.29.2214`

## Compatibility:

```
% java --version
openjdk 20 2023-03-21
OpenJDK Runtime Environment Homebrew (build 20)
OpenJDK 64-Bit Server VM Homebrew (build 20, mixed mode, sharing)
```

## General Description:

Ready to use customized collection of helper classes, containing many static & public utility functions. All of
them custom-made and ready to use. Just plug and play.

### DatabaseHelper

### Datesy

### JHArray

### Mathsy

### Rangy

Rangy is a super light version of the class [Range](https://github.com/google/guava/wiki/RangesExplained), included as
part of the Google Guava Package.

- [a..b] = {x | a <= x <= b}
- [a..b) = {x | a <= x < b}
- (a..b] = {x | a < x <= b}
- (a..+∞) = {x | x > a}
- [a..+∞) = {x | x >= a}
- (-∞..b) = {x | x < b}
- (-∞..b] = {x | x <= b}
- (-∞..+∞) = all values

| Range type | Method             |
|:-----------|:-------------------|
| `(a..b)`   | `open(C, C)`       |
| `[a..b]`   | `closed(C, C)`     |
| `[a..b)`   | `closedOpen(C, C)` |
| `(a..b]`   | `openClosed(C, C)` |
| `(a..+∞)`  | `greaterThan(C)`   |
| `[a..+∞)`  | `atLeast(C)`       |
| `(-∞..b)`  | `lessThan(C)`      |
| `(-∞..b]`  | `atMost(C)`        |
| `(-∞..+∞)` | `all()`            |

### Terminus

### TFile

## Author

**Reinier Garcia**

* [Github](https://github.com/reymillenium)
* [Twitter](https://twitter.com/ReinierGarciaR)
* [Linkedin](https://www.linkedin.com/in/reiniergarcia/)
* [Website](https://www.reiniergarcia.dev/)
* [Stack Overflow](https://stackoverflow.com/users/9616949/reinier-garcia)

### License

Copyright © 2024, [Reinier Garcia](https://github.com/reymillenium).



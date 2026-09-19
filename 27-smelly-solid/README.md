# SOLID Violations Kata

## Overview

This is a **verification fixture, not a practice exercise**. Each folder
contains a small, self-contained example of exactly one SOLID principle
violation, translated directly from *Agile Technical Practices Distilled*'s
SOLID chapter worked examples (Car/`save`, `CarEngineStatusReportController`,
`Chef`/`Oven`/`Microwave`, `IAmACar`, `Kitchen`/`MicrowaveOven`). Its purpose
is to give static-analysis/AI code-review tooling (specifically
[jev-review](https://github.com/pedromsantos/jev-review)) a known-answer set
to check its SOLID rules against -- every file's violation is deliberate and
documented below, not hidden.

This is the Java translation of the reference kata in ts-kata's
`25_SmellySolid`; equivalent kata exist for Go, Python, C#, and C too.

## What's here

| File | Violates | Why |
|---|---|---|
| `org/kata/solid/srp/Car.java` | SRP | `save()` mixes a persistence concern into a class otherwise about domain behaviour (mileage/travel) |
| `org/kata/solid/ocp/*.java` | OCP (and DIP) | every new report format needs a new method on the controller, and it constructs its concrete views directly instead of receiving them injected |
| `org/kata/solid/lsp/Microwave.java` | LSP | overrides `cook()` to throw instead of honouring the base contract |
| `org/kata/solid/lsp/Chef.java` | -- | not itself a violation, but its `instanceof Microwave` special-case is the client-code tell of `Microwave`'s LSP violation |
| `org/kata/solid/isp/IAmACar.java` | ISP | bundles `refillGasoline`/`refillElectricity`, capabilities no single car supports both of |
| `org/kata/solid/isp/ElectricCar.java` | -- | the forced implementer: throws on the gasoline method it can't honestly support |
| `org/kata/solid/dip/Kitchen.java` | DIP (and OCP) | constructs `MicrowaveOven` directly; can't work with any other oven without being edited |
| `org/kata/solid/dip/MicrowaveOven.java` | DIP | constructs `MicrowaveGenerator` directly instead of receiving it injected |

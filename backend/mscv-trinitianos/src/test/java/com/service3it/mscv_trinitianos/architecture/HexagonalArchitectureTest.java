package com.service3it.mscv_trinitianos.architecture;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;

public class HexagonalArchitectureTest {

    private static JavaClasses importedClasses;
    private static final String BASE_PACKAGE = "com.service3it.mscv_trinitianos";
    private static final String DOMAIN_PACKAGE = BASE_PACKAGE + ".domain..";
    private static final String APPLICATION_PACKAGE = BASE_PACKAGE + ".application..";
    private static final String INFRAESTRUCTURE_PACKAGE = BASE_PACKAGE + ".infraestructure..";
    private static final String PORTS_PACKAGE = BASE_PACKAGE + ".domain.ports..";
    private static final String ADAPTERS_PACKAGE = BASE_PACKAGE + ".infraestructure.adapters..";

    @BeforeAll
    public static void setup() {
        importedClasses = new ClassFileImporter().importPackages(BASE_PACKAGE);
    }

    @Test
    public void packagesShouldBeFreeOfCycles() {
        ArchRule rule = slices().matching("com.service3it.(*)..")
            .should().beFreeOfCycles();

        rule.check(importedClasses);
    }

    @Test
    public void domainShouldNotDependOnApplicationOrInfrastructure() {
        ArchRule rule = noClasses().that().resideInAPackage(DOMAIN_PACKAGE)
                .should().dependOnClassesThat().resideInAnyPackage(APPLICATION_PACKAGE, INFRAESTRUCTURE_PACKAGE);
        rule.check(importedClasses);
    }

    @Test
    public void applicationShouldNotDependOnInfrastructure() {
        ArchRule rule = noClasses().that().resideInAPackage(APPLICATION_PACKAGE)
                .should().dependOnClassesThat().resideInAPackage(INFRAESTRUCTURE_PACKAGE);
        rule.check(importedClasses);
    }

    @Test
    public void portsPackageShouldOnlyContainInterfaces() {
        ArchRule rule = classes().that().resideInAPackage(PORTS_PACKAGE)
                .should().beInterfaces();
        rule.check(importedClasses);
    }

    @Test
    public void adaptersShouldImplementPorts() {
        ArchRule inboundAdaptersRule = classes().that()
                .resideInAPackage("..infraestructure.adapters.in..")
                .should().dependOnClassesThat().resideInAnyPackage("..domain.ports.in..", "java..", "jakarta..", "lombok..");
        
        ArchRule outboundAdaptersRule = classes().that()
                .resideInAPackage("..infraestructure.adapters.out..")
                .should().dependOnClassesThat().resideInAnyPackage("..domain.ports.out..", "java..", "jakarta..", "lombok..");
        
        inboundAdaptersRule.check(importedClasses);
        outboundAdaptersRule.check(importedClasses);
    }

    @Test
    public void onlyAdaptersAndApplicationShouldAccessInboundPortsIn() {
        ArchRule rule = noClasses()
            .that().resideOutsideOfPackages(
                "..application..",
                "..infraestructure.adapters.in.."
        )
        .should().dependOnClassesThat().resideInAnyPackage("..domain.ports.in..");

        rule.check(importedClasses);
    }

    @Test
    public void onlyAdaptersAndApplicationShouldAccessInboundPortsOut() {
        ArchRule rule = noClasses()
            .that().resideOutsideOfPackages(
                "..application..",
                "..infraestructure.adapters.out.."
        )
        .should().dependOnClassesThat().resideInAnyPackage("..domain.ports.out..");

        rule.check(importedClasses);
    }
    

}

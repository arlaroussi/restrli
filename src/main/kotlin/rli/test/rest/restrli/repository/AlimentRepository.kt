package rli.test.rest.restrli.repository

import org.springframework.data.jpa.repository.JpaRepository
import rli.test.rest.restrli.model.Aliment
import rli.test.rest.restrli.model.Box

interface AlimentRepository : JpaRepository<Aliment, Int> {
}
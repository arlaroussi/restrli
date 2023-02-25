package rli.test.rest.restrli.repository

import org.springframework.data.jpa.repository.JpaRepository
import rli.test.rest.restrli.model.Box

interface BoxRepository : JpaRepository<Box, Int>{
}
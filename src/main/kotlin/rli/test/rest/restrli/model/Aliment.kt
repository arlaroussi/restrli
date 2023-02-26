package rli.test.rest.restrli.model

import jakarta.persistence.*

@Entity
class Aliment(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long,

    @Column(name = "nom", nullable = false)
    var nom: String,

    @Column(name = "quantite", nullable = false)
    var quantite: String,

    @ManyToOne()
    val box: Box? = null
)
package rli.test.rest.restrli.model

import jakarta.persistence.*

@Entity
@Table(name="box")
class Box(
    @Column(name = "nom",  nullable = false)
    var nom: String,

    @Column(name = "pieces", nullable = false)
    var pieces: Int,

    @Column(name = "prix", nullable = false)
    var prix: Double,

    @Column(name = "img", nullable = false)
    var image: String,

    @Id @GeneratedValue
    var id: Long? = null,

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "box")
    var aliments: List<Aliment>? = null,
)
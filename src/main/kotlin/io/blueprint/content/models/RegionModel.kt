package io.blueprint.content.models

import javax.persistence.*

@Entity
@Table(name = "region")
class RegionModel {
    @Id
    @GeneratedValue
    var id: Int = 0

    @Column(name = "pin_code")
    var pinCode: Int = 0

    @Column
    var city: String = ""

    @Column
    var country: String = ""
}

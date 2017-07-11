package net.corda.core.transactions

import net.corda.core.contracts.NamedByHash
import net.corda.core.contracts.StateRef
import net.corda.core.identity.Party

interface BaseWireTransaction : NamedByHash {
    /** The inputs of this transaction. Note that in BaseTransaction subclasses the type of this list may change! */
    val inputs: List<StateRef>

    /**
     * If present, the notary for this transaction. If absent then the transaction is not notarised at all.
     * This is intended for issuance/genesis transactions that don't consume any other states and thus can't
     * double spend anything.
     */
    val notary: Party?
}
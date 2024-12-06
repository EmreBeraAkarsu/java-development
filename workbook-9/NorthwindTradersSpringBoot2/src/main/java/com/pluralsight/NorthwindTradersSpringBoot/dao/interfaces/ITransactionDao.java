package com.pluralsight.NorthwindTradersSpringBoot.dao.interfaces;

public interface ITransactionDao {

    Transaction add(Transaction transaction);

    /**
     * Retrieves all transactions from the data store.
     *
     * @return A list of all transactions.
     */
    List<Transaction> getAllTransactions();

    /**
     * Retrieves a specific transaction by its ID.
     *
     * @param transactionId The ID of the transaction to retrieve.
     * @return The Transaction object if found, or null otherwise.
     */
    Transaction getTransactionById(int transactionId);

    /**
     * Updates an existing transaction in the data store.
     *
     * @param transactionId The ID of the transaction to update.
     * @param transaction The Transaction object with updated information.
     */
    void update(int transactionId, Transaction transaction);

    /**
     * Deletes a transaction from the data store.
     *
     * @param transactionId The ID of the transaction to delete.
     */
    void delete(int transactionId);
}

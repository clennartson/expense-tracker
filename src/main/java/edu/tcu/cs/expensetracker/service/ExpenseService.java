package edu.tcu.cs.expensetracker.service;

import edu.tcu.cs.expensetracker.domain.Expense;
import edu.tcu.cs.expensetracker.dao.ExpenseDao;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ExpenseService {

    private ExpenseDao expenseDao;

    // Spring will automatically inject an instance of ArtifactDao and an instance of IdWorker into this class

    public ExpenseService(ExpenseDao expenseDao) {
        this.expenseDao = expenseDao;
    }

    public List<Expense> findAll(){ return expenseDao.findAll(); }

    public Expense findById(String expenseId) { return expenseDao.findById(expenseId).get(); }

    public void save(Expense newExpense) {
        expenseDao.save(newExpense);
    }

    public void update(String expenseId, Expense updatedExpense) {
        updatedExpense.setId(expenseId);
        expenseDao.save(updatedExpense);
    }

    public void delete(String expenseId) {
        expenseDao.deleteById(expenseId);
    }
}